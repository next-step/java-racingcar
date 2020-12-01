package com.nextstep.calculator;

import java.io.InputStream;
import java.util.Scanner;

public class InputReader {
    private final Scanner scanner;

    public InputReader(){
        this(System.in);
    }

    public InputReader(InputStream is){
        scanner = new Scanner(is);
    }

    public String readString(){
        return scanner.nextLine();
    }
}
