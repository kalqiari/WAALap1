package edu.miu.lab1.service;

import edu.miu.lab1.entity.Post;
import edu.miu.lab1.entity.dto.PostDto;
import edu.miu.lab1.repo.PostRepo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostServiceImp implements PostService {

    @Autowired
    PostRepo postRepo;
    @Autowired
    ModelMapper modelMapper;
    @Override
    public List<PostDto> findAll() {
        return postRepo.findAll().stream().map( e-> modelMapper.map(e, PostDto.class)).collect(Collectors.toList());
    }

    @Override
    public PostDto findById(int id) {
        PostDto d = modelMapper.map(postRepo.findById(id), PostDto.class);
        return d;
    }

    @Override
    public void deleteById(int id) {
        postRepo.deleteById(id);
    }

    @Override
    public void save(PostDto p) {
        postRepo.save(modelMapper.map(p, Post.class));
    }

    @Override
    public void update(int postId, PostDto p) {
        postRepo.update(postId ,(Post) modelMapper.map(p, Post.class));
    }

    @Override
    public List<PostDto> findAllByAuther(String author) {
        return postRepo.findAllByAuther(author).stream().map( e-> modelMapper.map(e, PostDto.class)).collect(Collectors.toList());

    }
}
