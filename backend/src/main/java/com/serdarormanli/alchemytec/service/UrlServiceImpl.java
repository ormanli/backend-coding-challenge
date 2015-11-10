package com.serdarormanli.alchemytec.service;

import com.serdarormanli.alchemytec.model.Url;
import com.serdarormanli.alchemytec.repository.UrlRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("urlServiceImpl")
public class UrlServiceImpl implements UrlService {

    @Autowired
    UrlRepository urlRepository;

    @Override
    public List<Url> getUrlList() {
        return urlRepository.findAll();
    }

    @Override
    public Url insertNewUrl(Url newUrl) {
        return urlRepository.save(newUrl);
    }

    @Override
    public void updateUrl(Url updatedUrl) {
        urlRepository.save(updatedUrl);
    }

    @Override
    public void deleteUrl(String id) {
        urlRepository.delete(id);
    }

    @Override
    public Url getUrl(String id) {
        return urlRepository.findOne(id);
    }

}
