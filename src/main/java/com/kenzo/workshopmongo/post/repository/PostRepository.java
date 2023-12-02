package com.kenzo.workshopmongo.post.repository;

import com.kenzo.workshopmongo.post.model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

    @Repository
    public interface PostRepository extends MongoRepository<Post, String> {

    }
