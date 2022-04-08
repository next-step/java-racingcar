package me.devyonghee.racingcar.controller;

import me.devyonghee.racingcar.utility.Assert;
import me.devyonghee.racingcar.view.InputView;
import me.devyonghee.racingcar.view.ResultView;

import java.io.PrintStream;
import java.util.Scanner;

public final class RacingCarRace {

    private final InputView inputView;
    private final ResultView resultView;

    private RacingCarRace(Scanner scanner, PrintStream output) {
        Assert.notNull(scanner, "'scanner' must not be null");
        Assert.notNull(output, "'output' must not be null");
        this.inputView = InputView.of(scanner, output);
        this.resultView = ResultView.from(output);
    }

    public static RacingCarRace of(Scanner scanner, PrintStream output) {
        return new RacingCarRace(scanner, output);
    }

    public void race() {

    }
}
