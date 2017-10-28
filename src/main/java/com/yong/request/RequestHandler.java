package com.yong.request;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import static java.util.stream.Collectors.joining;

public class RequestHandler {
    private String message;

    public RequestHandler(InputStream is){
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        this.message = reader.lines()
                .collect(joining());
    }

    public Request parse(){
        return null;
    }

    public void handle(){

    }
}
