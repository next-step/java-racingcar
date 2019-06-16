package com.jaeyeonling.racingcar.view;

import com.jaeyeonling.racingcar.domain.Visualizable;

import java.io.PrintStream;

public final class ResultView {

    private static final PrintStream console = System.out;

    private ResultView() { }

    public static void show(final Visualizable target) {
        show(target.visualize());
    }

    public static void newLine() {
        console.println();
    }

    public static void show(final String message) {
        console.println(message);
    }
}
