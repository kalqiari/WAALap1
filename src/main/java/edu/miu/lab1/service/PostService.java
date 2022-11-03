package edu.miu.lab1.service;

import edu.miu.lab1.entity.dto.PostDto;

import java.util.List;

public interface PostService {
    List<PostDto> findAll();

    PostDto findById(int id);

    void deleteById(int id);

    void save(PostDto p);

    void update(int postId, PostDto p);

    List<PostDto> findAllByAuther(String author);
}
