package edu.miu.lab1.controller;

import edu.miu.lab1.entity.PostV2;
import edu.miu.lab1.entity.dto.PostDto;
import edu.miu.lab1.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/posts")
@RestController
public class PostController {

    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("")
    public List<PostDto> allPost(@RequestParam(value = "filter" ,required = false) String author) {
        return author == null ? postService.findAll() : postService.findAllByAuther(author);
    }

    @GetMapping("/{id}")
    public PostDto getById(@PathVariable int id) {
        return postService.findById(id);
    }


    @GetMapping(value = "/{id}", headers = "X-API-VERSION=2")
    public PostV2 getByIdV2(@PathVariable int id){
        return new PostV2(id, "test v2", "test V2","test");
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id) {
        postService.deleteById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void save(@RequestBody PostDto p) {
        postService.save(p);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") int postId, @RequestBody PostDto p) {
        postService.update(postId,p);
    }

}
