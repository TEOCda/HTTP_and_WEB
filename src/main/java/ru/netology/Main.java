package ru.netology;

import java.io.*;
public class Main {
    public static void main(String[] args) {
        Server server = new Server(64);
        server.start(9999);
    }
}