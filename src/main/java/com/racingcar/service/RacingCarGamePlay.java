package com.racingcar.service;

import com.racingcar.model.RacingCar;
import com.racingcar.model.RacingCarGame;

import java.util.List;
import java.util.stream.IntStream;

public class RacingCarGamePlay {

    private RacingCarInput racingCarInput;
    private RacingCarPrinter racingCarPrinter;

    public RacingCarGamePlay() {
        this.racingCarInput = new RacingCarInput();
        this.racingCarPrinter = new RacingCarPrinter();
    }

    public void playRacingCarGame() {
        RacingCarGame racingCarGame = racingCarInput.inputRacingCarData();
        IntStream.range(0, racingCarGame.getCountOfAttempt()).forEach(i -> {
            racingCarGame.playRacingGame();
            racingCarPrinter.printRacingCar(racingCarGame.getRacingCars());
        });

        List<RacingCar> racingCars = racingCarGame.extractWinner();
        racingCarPrinter.printWinner(racingCars);
    }
}
