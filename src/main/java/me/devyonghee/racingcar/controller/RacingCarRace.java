package me.devyonghee.racingcar.controller;

import me.devyonghee.racingcar.model.*;
import me.devyonghee.racingcar.utility.Assert;
import me.devyonghee.racingcar.view.InputView;
import me.devyonghee.racingcar.view.ResultView;
import me.devyonghee.racingcar.view.dto.TracksHistoryResponse;
import me.devyonghee.racingcar.view.dto.WinnerResponse;

import java.io.PrintStream;
import java.util.Random;
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
        TracksHistory history = racingStadium(inputView.carNames(), inputView.cycleCount()).history();
        resultView.print(TracksHistoryResponse.from(history));
        resultView.print(WinnerResponse.from(history.lastFarthestTracks()));
    }

    private RacingStadium racingStadium(String names, int cycleCount) {
        return RacingStadium.of(CarPreparer.of(carFactory(names), Distance.ZERO), cycleCount);
    }

    private CarFactory carFactory(String names) {
        return CarFactory.of(NameWriter.from(names), RandomMovementPolicy.from(new Random()));
    }
}
