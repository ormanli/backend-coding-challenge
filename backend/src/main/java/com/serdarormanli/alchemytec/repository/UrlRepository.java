package com.serdarormanli.alchemytec.repository;

import com.serdarormanli.alchemytec.model.Url;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UrlRepository extends MongoRepository<Url, String> {

}
