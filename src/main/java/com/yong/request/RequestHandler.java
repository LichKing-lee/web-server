package com.yong.request;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class RequestHandler {
    public RequestHandler(Socket socket){
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

        } catch (IOException e) {

        }
    }
}
