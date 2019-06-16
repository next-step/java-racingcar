package com.jaeyeonling.racingcar.view;

import com.jaeyeonling.racingcar.domain.Visualizable;

import java.io.PrintStream;

public class ResultView {

    private final PrintStream writer;

    public ResultView(final PrintStream target) {
        writer = target;
    }

    public void show(final Visualizable target) {
        show(target.visualize());
    }

    public void newLine() {
        writer.println();
    }

    public void show(final String message) {
        writer.println(message);
    }
}
