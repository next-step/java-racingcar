package com.racingcar.service;

import com.racingcar.model.RacingCarGame;

import java.util.stream.IntStream;

public class RacingCarPlay {

    private RacingCarInput racingCarInput;
    private RacingCarPrinter racingCarPrinter;

    public RacingCarPlay() {
        this.racingCarInput = new ScannerRacingCarInput();
        this.racingCarPrinter = new DefaultRacingCarPrinter();
    }

    public void playRacingCarGame() {
        RacingCarGame racingCarGame = racingCarInput.inputRacingCarData();
        IntStream.range(0, racingCarGame.getCountOfAttempt()).forEach(i -> {
            racingCarGame.playRacingGame();
            racingCarPrinter.printRacingCar(racingCarGame.getRacingRacingCars());
        });
    }
}
