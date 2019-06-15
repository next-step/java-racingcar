package com.jaeyeonling.racingcar.view;

import java.io.InputStream;
import java.util.Scanner;

public class InputView {

    private final Scanner scanner;

    public InputView(final InputStream source) {
        scanner = new Scanner(source);
    }

    public String readFromConsole() {
        return scanner.nextLine();
    }

    public String readFromConsoleWithMessage(final String message) {
        System.out.println(message);
        return readFromConsole();
    }
}
