package com.yong.main;

import com.yong.request.RequestHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Start {
    public static void main(String[] args) {
        try(ServerSocket serverSocket = new ServerSocket(9000)) {
            System.out.println("start web server");
            Socket socket;
            while((socket = serverSocket.accept()) != null){
                RequestHandler handler = new RequestHandler(socket.getInputStream());
            }
        }catch (IOException ie){
            System.out.println("server io exception");
        }
    }
}
