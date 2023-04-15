package com.next.step.step3.service;

import com.next.step.step3.domain.Cars;
import com.next.step.step3.domain.MoveResult;
import com.next.step.step3.domain.MoveResults;
import com.next.step.step3.dto.InputDto;
import com.next.step.step3.util.CarsFactory;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private Cars cars;

    private int numOfAttempts;

    public RacingGame(InputDto inputDto) {
        this.cars = new Cars(CarsFactory.createCars(inputDto));
        this.numOfAttempts = inputDto.numOfAttempts();
    }

    public MoveResults executeRace() {
        List<MoveResult> moveResults = new ArrayList<>();
        for (int attempt = 0; attempt < numOfAttempts; attempt++) {
            cars.moveCars();
            moveResults.add(new MoveResult(cars.carElements()));
        }

        return new MoveResults(moveResults, cars);
    }
}
