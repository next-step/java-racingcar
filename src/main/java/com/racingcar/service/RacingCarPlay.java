package com.racingcar.service;

import com.racingcar.model.Player;
import com.racingcar.model.RacingCar;

import java.util.List;
import java.util.stream.IntStream;

public class RacingCarPlay {

    private RacingCarPlayerAccessor racingCarPlayerAccessor;
    private RacingCarPlayRule racingCarPlayRule;
    private PrintRacingCar printRacingCar;

    public RacingCarPlay() {
        this.racingCarPlayerAccessor = new ScannerRacingCarPlayerAccessor();
        this.racingCarPlayRule = new DefaultRacingCarRule();
        this.printRacingCar = new DefaultPrintRacingCar();
    }

    public void playRacingCar() {

        Player player = racingCarPlayerAccessor.accessRacingCarPlayer();

        Integer countOfAttempt = player.getCountOfAttempt();
        IntStream.range(0, countOfAttempt).forEach(i -> {
            List<RacingCar> racingCars = player.getRacingRacingCars();
            doEachRacingCarPlay(racingCars);
        });
    }

    private void doEachRacingCarPlay(List<RacingCar> racingCars) {

        for (RacingCar racingCar : racingCars) {
            racingCarPlayRule.moveRacingCar(racingCar);
            printRacingCar.printRacingCar(racingCar);
        }

        System.out.println();
    }
}
