package com.jaeyeonling.racingcar.view;

import java.util.Scanner;

public final class InputView {

    private static final Scanner console = new Scanner(System.in);

    private InputView() { }

    public static String readString() {
        return console.nextLine();
    }

    public static String readStringWithMessage(final String message) {
        System.out.println(message);
        return readString();
    }

    public static int readInt() {
        return console.nextInt();
    }

    public static int readIntWithMessage(final String message) {
        System.out.println(message);
        return readInt();
    }


}
