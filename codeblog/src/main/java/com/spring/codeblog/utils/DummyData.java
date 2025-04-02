package com.spring.codeblog.utils;

import com.spring.codeblog.model.Post;
import com.spring.codeblog.repository.CodeblogRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class DummyData {
    @Autowired
    CodeblogRepository codeblogRepository;

   // @PostConstruct
    public void savePosts(){
        List<Post> postList = new ArrayList<>();
        Post post = new Post();
        post.setAutor("Felipe Bertoni");
        post.setData(LocalDate.now());
        post.setTitulo("Primeiro Titulo");
        post.setTexto("Esse é meu primeiro texto do Codeblog, onde foi feito para estudos do Spring Boot e Deploy AWS");

        Post post2 = new Post();
        post2.setAutor("Guilherme Andrade");
        post2.setData(LocalDate.now());
        post2.setTitulo("Meu segundo titulo do blog Codeblog");
        post2.setTexto("Esse é meu segundo texto do Codeblog, onde foi feito para estudos do Spring Boot e Deploy AWS");

        postList.add(post);
        postList.add(post2);

        for (Post posts : postList) {
            Post postSaved = codeblogRepository.save(posts);
            System.out.println(postSaved.getId());
        }

    }



}
