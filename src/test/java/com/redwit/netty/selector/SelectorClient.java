package com.redwit.netty.selector;

import java.io.IOException;
import java.net.Socket;

/**
 * @description:
 * @author: yangjiang
 * @create: 2022-02-15 14:47
 **/
public class SelectorClient {

    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 8080)) {
            System.out.println(socket);
            socket.getOutputStream().write("world".getBytes());
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
