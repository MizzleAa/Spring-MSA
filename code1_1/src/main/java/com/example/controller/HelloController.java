package com.example.controller;

import com.example.payload.response.Message;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "hello")
public class HelloController {

    @GetMapping(value="/{firstName}/{lastName}")
    public ResponseEntity<?> hello(
        @PathVariable("firstName") String firstName,
        @PathVariable("lastName") String lastName
    ){
        log.info("hello = {}/{}", firstName, lastName);
        return ResponseEntity.ok(
            Message.builder().message(String.format("%s/%s", firstName,lastName )).build()
        );
    }
}
