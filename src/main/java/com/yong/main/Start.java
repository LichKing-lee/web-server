package com.yong.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import static java.util.stream.Collectors.joining;

public class Start {
    public static void main(String[] args) {
        try(ServerSocket serverSocket = new ServerSocket(9000)) {
            Socket socket;
            while((socket = serverSocket.accept()) != null) {
                String message = new BufferedReader(new InputStreamReader(socket.getInputStream())).lines()
                .collect(joining("\n"));

                System.out.println(message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(999);
    }
}
