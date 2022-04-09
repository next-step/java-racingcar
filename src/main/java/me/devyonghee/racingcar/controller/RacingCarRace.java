package me.devyonghee.racingcar.controller;

import me.devyonghee.racingcar.model.*;
import me.devyonghee.racingcar.utility.Assert;
import me.devyonghee.racingcar.view.InputView;
import me.devyonghee.racingcar.view.ResultView;
import me.devyonghee.racingcar.view.dto.TracksHistoryResponse;

import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;

public final class RacingCarRace {

    private static final int RANDOM_LIMIT = 10;

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
        resultView.print(TracksHistoryResponse.from(
                racingStadium(inputView.carCount(), inputView.cycleCount()).history()
        ));
    }

    private RacingStadium racingStadium(int carCount, int cycleCount) {
        return RacingStadium.of(CarPreparer.of(carFactory(carCount), Distance.ZERO), cycleCount);
    }

    private CarFactory carFactory(int carCount) {
        return CarFactory.of(carCount, RandomEngine.from(new Random(), RANDOM_LIMIT));
    }
}
