package com.serdarormanli.alchemytec.controller;

import com.serdarormanli.alchemytec.model.Url;
import com.serdarormanli.alchemytec.model.UrlBase;
import com.serdarormanli.alchemytec.util.IdToBase;

import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@RestController
public class UrlController {

    @Autowired
    private IdToBase idToBase;

    @RequestMapping(value = "/shorten", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Url insertNewUrl(@Valid @RequestBody UrlBase requestJson) {
        int num = RandomUtils.nextInt(5000, 999999);
        return new Url(requestJson.getRealUrl(), idToBase.encode(num), Integer.toString(num));
    }

    @RequestMapping(value = "/shorten/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public UrlBase greeting(@PathVariable("id") String id) {
        return new Url("http://www.google.com", "dfsd", id).getSuper();
    }

    @RequestMapping(value = "/s/{id}", method = RequestMethod.GET)
    public ModelAndView redirect(@PathVariable("id") String id) {
        // TODO idden alan adına yönlendiren kod eklenecek.
        String redirectUrl = "http://www.google.com";
        return new ModelAndView("redirect:" + redirectUrl);
    }

}