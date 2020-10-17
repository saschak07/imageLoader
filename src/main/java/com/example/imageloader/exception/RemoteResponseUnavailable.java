package com.example.imageloader.exception;

import lombok.AllArgsConstructor;
public class RemoteResponseUnavailable  extends RuntimeException{
    public RemoteResponseUnavailable(String message) {
        super(message);
    }
}
