package com.racingcar.service;

import com.racingcar.model.RacingCar;

import java.util.List;
import java.util.stream.IntStream;

public class DefaultRacingCarPrinter implements RacingCarPrinter {

    @Override
    public void printRacingCar(List<RacingCar> racingCars) {

        for (RacingCar racingCar : racingCars) {
            Integer racingCarStatus = racingCar.getRacingStatus();
            IntStream.range(0, racingCarStatus).forEach(i -> System.out.print("-"));
            System.out.println();
        }

        System.out.println();
    }
}
