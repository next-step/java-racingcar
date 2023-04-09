package com.next.step.step3.service;

import com.next.step.step3.domain.Car;
import com.next.step.step3.dto.InputDto;
import com.next.step.step3.util.RandomNumberGenerator;
import com.next.step.step3.view.ResultView;

import java.util.List;

public class GameExecutor {

    public void executeGame(List<Car> cars, InputDto inputDto) {
        ResultView resultView = new ResultView();

        resultView.showResultTitle();
        for (int attempt = 0; attempt < inputDto.numOfAttempts(); attempt++) {
            moveCars(cars);
            resultView.showResultContents(cars);
        }
    }

    private void moveCars(List<Car> cars) {
        for (Car car : cars) {
            int randomNum = RandomNumberGenerator.generateRandomNum();
            car.moveCar(randomNum);
        }
    }
}
