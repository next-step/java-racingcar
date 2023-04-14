package com.next.step.step3.service;

import com.next.step.step3.domain.Cars;
import com.next.step.step3.domain.Winner;
import com.next.step.step3.dto.InputDto;
import com.next.step.step3.util.CarsFactory;
import com.next.step.step3.view.ResultView;

import java.util.List;

public class RacingGame {

    private Cars cars;

    public RacingGame(InputDto inputDto) {
        this.cars = new Cars(CarsFactory.createCars(inputDto));
    }

    public List<String> executeRace(int numOfAttempts) {
        ResultView resultView = new ResultView();

        resultView.showResultTitle();
        for (int attempt = 0; attempt < numOfAttempts; attempt++) {
            cars.moveCars();
            resultView.showResultContents(cars);
        }

        Winner winner = new Winner(cars);
        return winner.getWinnerNames();
    }
}
