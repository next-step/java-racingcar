package com.racingcar.controller;

import com.racingcar.domain.RacingCar;
import com.racingcar.domain.RacingCarGame;
import com.racingcar.view.RacingCarInput;
import com.racingcar.view.RacingCarPrinter;

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
