package com.jaeyeonling.racingcar.view;

import java.io.PrintStream;

public final class ConsoleResultView {

    private static final PrintStream console = System.out;

    private ConsoleResultView() { }

    public static void show(final Visualizable target) {
        show(target.visualize());
    }

    public static void show(final String message) {
        console.println(message);
    }
}