package com.example.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Service
@RefreshScope
@RequiredArgsConstructor
public class HelloService {
    
    @Value("${mizzle.profile}")
    private String profile;
    
    @Value("${mizzle.comment}")
    private String comment;

    public ResponseEntity<?> getProfile(){
        return ResponseEntity.ok(profile);
    }

    public ResponseEntity<?> getComment(){
        return ResponseEntity.ok(comment);
    }
}
