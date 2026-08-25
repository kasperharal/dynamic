package com.dynamic;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) throws DynamicExeption, IOException {
        System.out.println(new DynamicSet(Files.readString(Path.of("test.dyn"))));
    }
}