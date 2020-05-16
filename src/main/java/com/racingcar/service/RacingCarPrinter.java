package com.racingcar.service;

import com.racingcar.model.RacingCar;

import java.util.List;

public interface RacingCarPrinter {

    void printRacingCar(List<RacingCar> racingCars);

    void printWinner(List<RacingCar> racingCars);
}
