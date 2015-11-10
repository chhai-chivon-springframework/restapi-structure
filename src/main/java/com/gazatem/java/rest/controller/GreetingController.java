package com.gazatem.java.rest.controller;

import com.gazatem.java.rest.Greeting;
import com.gazatem.java.rest.Shop;
import com.gazatem.java.rest.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class GreetingController {

    @Autowired
    private ShopService shopService;

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }

    @RequestMapping(value="/list", method= RequestMethod.GET)
    public List<Shop> shopListPage() {
        List<Shop> shopList = shopService.findAll();
        return shopList;
    }

}
