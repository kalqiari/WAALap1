package edu.miu.lab1.repo;

import edu.miu.lab1.entity.Post;

import java.util.Collection;
import java.util.List;


public interface PostRepo {
    List<Post> findAll();
    Post findById(int id);

    void deleteById(int id);

    void save(Post p);

    void update(int postId, Post p);

    List<Post> findAllByAuther(String author);
}
