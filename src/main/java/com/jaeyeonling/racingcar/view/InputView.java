package com.jaeyeonling.racingcar.view;

import java.io.InputStream;
import java.util.Scanner;

public class InputView {

    private final Scanner reader;

    public InputView(final InputStream source) {
        reader = new Scanner(source);
    }

    public String readFromConsole() {
        return reader.nextLine();
    }

    public String readFromConsoleWithMessage(final String message) {
        System.out.println(message);
        return readFromConsole();
    }
}
