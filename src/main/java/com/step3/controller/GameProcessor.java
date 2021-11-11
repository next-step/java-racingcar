package com.step3.controller;

import com.step3.model.car.Car;
import com.step3.model.InputNumber;
import com.step3.model.car.Cars;
import com.step3.util.RandomUtil;
import com.step3.view.ResultView;

public class GameProcessor {
    public void moveCars(InputNumber myNumber) {
        Cars cars = new Cars(myNumber.getCarsName());

        for (int attempt = 0; attempt < myNumber.getAttemptCount(); attempt++) {
            ResultView.showResults(cars.moveCars(), attempt);
        }

        ResultView.printWinnerResult(cars);
    }
}
