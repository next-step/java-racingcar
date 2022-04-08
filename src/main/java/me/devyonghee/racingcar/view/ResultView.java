package me.devyonghee.racingcar.view;

import me.devyonghee.racingcar.utility.Assert;

import java.io.PrintStream;

public final class ResultView {

    private static final String RESULT_MESSAGE = "실행 결과";

    private final PrintStream output;

    private ResultView(PrintStream output) {
        Assert.notNull(output, "'output' must not be null");
        this.output = output;
    }

    public static ResultView from(PrintStream output) {
        return new ResultView(output);
    }

    public void print() {
        output.println(RESULT_MESSAGE);
    }
}
