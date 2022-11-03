package edu.miu.lab1.repo;

import edu.miu.lab1.entity.Post;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PostRepoImpl implements PostRepo {
    private static List<Post> posts;
    private static int postId = 4;
    static {
        posts = new ArrayList<>();
        posts.add(new Post(1,"title 1","content 1", "auther1"));
        posts.add(new Post(2,"title 2","content 2", "auther2"));
        posts.add(new Post(3,"title 3","content 3", "auther3"));

    }
    @Override
    public List<Post> findAll() {
        return posts;
    }

    @Override
    public Post findById(int id) {
        return posts.stream().filter(e-> e.getId() == id).findFirst().orElse(null);
    }

    @Override
    public void deleteById(int id) {
        var post =posts
                .stream()
                .filter(l -> l.getId() == id)
                .findFirst().orElse(null);
        if(post != null)
          posts.remove(post);
    }

    @Override
    public void save(Post p) {
        p.setId(postId++);
        posts.add(p);
    }

    @Override
    public void update(int postId, Post p) {
        var post = findById(postId);
        if(post != null)
        {
            post.setAuthor(p.getAuthor());
            post.setContent(p.getContent());
            post.setTitle(p.getTitle());
        }

    }

    @Override
    public List<Post> findAllByAuther(String author) {
        return posts
                .stream()
                .filter(l -> l.getAuthor().equals(author)).collect(Collectors.toList());
    }
}
