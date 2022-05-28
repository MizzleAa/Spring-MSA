package com.example.payload.response;

import lombok.Builder;
import lombok.Data;

@Data
public class Message {
    Object message;

    public Message(){}
    
    @Builder
    public Message(Object message){
        this.message = message;
    }
}
