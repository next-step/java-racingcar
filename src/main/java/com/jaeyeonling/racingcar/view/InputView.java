package com.jaeyeonling.racingcar.view;

import java.io.InputStream;
import java.util.Scanner;

public class InputView {

    private final Scanner reader;

    public InputView(final InputStream source) {
        reader = new Scanner(source);
    }

    public String readString() {
        return reader.nextLine();
    }

    public String readStringWithMessage(final String message) {
        System.out.println(message);
        return readString();
    }

    public int readInt() {
        return reader.nextInt();
    }

    public int readIntWithMessage(final String message) {
        System.out.println(message);
        return readInt();
    }
}
