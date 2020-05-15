package com.racingcar.service;

import com.racingcar.model.RacingCar;

import java.util.stream.IntStream;

public class DefaultPrintRacingCar implements PrintRacingCar {

    @Override
    public void printRacingCar(RacingCar racingCar) {
        Integer racingCarStatus = racingCar.getRacingStatus();
        IntStream.range(0, racingCarStatus).forEach(i -> System.out.print("-"));
        System.out.println();
    }
}
