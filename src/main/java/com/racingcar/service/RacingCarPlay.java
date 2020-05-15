package com.racingcar.service;

import com.racingcar.model.RacingCarGame;

public class RacingCarPlay {

    private RacingCarInput racingCarInput;
    private RacingCarPrinter racingCarPrinter;

    public RacingCarPlay() {
        this.racingCarInput = new ScannerRacingCarInput();
        this.racingCarPrinter = new DefaultRacingCarPrinter();
    }

    public void playRacingCarGame() {
        RacingCarGame racingCarGame = racingCarInput.inputRacingCarData();
        racingCarGame.playRacingGame();
        racingCarPrinter.printRacingCar(racingCarGame.getRacingRacingCars());
    }
}
