package com.alphaomega;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) throws AlphaOmegaExeption, IOException {
        System.out.println(new GreekTable(Files.readString(Path.of("test.ao"))));
    }
}