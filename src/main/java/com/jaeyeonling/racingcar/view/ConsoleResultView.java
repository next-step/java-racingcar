package com.jaeyeonling.racingcar.view;

public final class ConsoleResultView {

    private static final ResultView console = new ResultView(System.out);

    private ConsoleResultView() { }

    public static void show(final Visualizable target) {
        show(target.visualize());
    }

    public static void show(final String message) {
        console.show(message);
    }
}
