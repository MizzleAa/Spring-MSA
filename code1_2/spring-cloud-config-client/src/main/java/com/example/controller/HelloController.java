package com.example.controller;

import com.example.payload.response.Message;
import com.example.service.HelloService;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "client")
public class HelloController {

    private final HelloService helloService;

    @GetMapping(value="/{firstName}/{lastName}")
    public ResponseEntity<?> hello(
        @PathVariable("firstName") String firstName,
        @PathVariable("lastName") String lastName
    ){
        log.info("Client : hello = {}/{}", firstName, lastName);
        return ResponseEntity.ok(
            Message.builder().message(String.format("%s/%s", firstName,lastName )).build()
        );
    }

    @GetMapping(value="/comment")
    public ResponseEntity<?> getComment(){
        return helloService.getComment();
    }

    @GetMapping(value="/profile")
    public ResponseEntity<?> getProfile(){
        return helloService.getProfile();
    }
}
