package com.next.step.step3.service;

import com.next.step.step3.domain.Car;
import com.next.step.step3.dto.InputDto;
import com.next.step.step3.util.CarsFactory;

import java.util.List;

public class RacingGame {

    public void executeRace(InputDto inputDto) {
        GameExecutor gameExecutor = new GameExecutor();

        List<Car> cars = CarsFactory.createCars(inputDto);
        gameExecutor.executeGame(cars, inputDto);
    }
}
