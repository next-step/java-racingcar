package com.jaeyeonling.racingcar.view;

public final class ConsoleInputView {

    private static final InputView console = new InputView(System.in);

    private ConsoleInputView() { }

    public static String readString() {
        return console.readString();
    }

    public static String readStringWithMessage(final String message) {
        System.out.println(message);
        return readString();
    }

    public static int readInt() {
        return console.readInt();
    }

    public static int readIntWithMessage(final String message) {
        System.out.println(message);
        return readInt();
    }
}
