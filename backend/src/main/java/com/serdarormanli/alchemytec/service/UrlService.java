package com.serdarormanli.alchemytec.service;

import com.serdarormanli.alchemytec.model.Url;

import java.util.List;

public interface UrlService {

    List<Url> getUrlList();

    Url insertNewUrl(Url newUser);

    void updateUrl(Url updatedUser);

    void deleteUrl(String id);

    Url getUrl(String id);
}