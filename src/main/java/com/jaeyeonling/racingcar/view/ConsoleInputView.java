package com.jaeyeonling.racingcar.view;

import java.util.Scanner;

public final class ConsoleInputView {

    private static final Scanner reader = new Scanner(System.in);

    private ConsoleInputView() { }

    public static String readString() {
        return reader.nextLine();
    }

    public static String readStringWithMessage(final String message) {
        System.out.println(message);
        return readString();
    }

    public static int readInt() {
        return reader.nextInt();
    }

    public static int readIntWithMessage(final String message) {
        System.out.println(message);
        return readInt();
    }
}
