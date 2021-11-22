package com.step3.controller;

import com.step3.model.InputNumber;
import com.step3.model.car.Cars;
import com.step3.model.car.strategy.CarMoveStrategy;
import com.step3.view.ResultView;

public class GameProcessor {
    public void startGame(InputNumber myNumber) {
        Cars cars = Cars.createFromName(myNumber.getCarsName());

        for (int attempt = 0; attempt < myNumber.getAttemptCount(); attempt++) {
            ResultView.showResults(cars.moveCars(new CarMoveStrategy()), attempt);
        }

        ResultView.printWinnerResult(cars);
    }
}
