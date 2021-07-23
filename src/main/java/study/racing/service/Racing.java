package study.racing.service;

import study.racing.domain.Car;
import study.racing.domain.Cars;
import study.racing.view.DrawDisplay;

import java.util.List;

import static study.racing.common.Common.printMessage;
import static study.racing.common.Message.MSG_ROUND_RESULT;
import static study.racing.validation.Validation.checkValue;

public class Racing {

    private Cars cars;

    public Racing(int carCount, int roundCount) {
        //validationValues(carCount, roundCount);
        this.cars = createCars(carCount);

        playingRounds(roundCount);
    }

    private void playingRounds(int roundCount) {
        printMessage(MSG_ROUND_RESULT);
        for (int i = 0; i < roundCount; i++) {
            runningCars();
            drawingCars();
        }
    }

    private void drawingCars() {
        new DrawDisplay(cars.getCars());
    }

    private Cars createCars(int carCount) {
        return new Cars(carCount);
    }

    private void validationValues(Integer carCount, Integer roundCount) {
        checkValue(carCount);
        checkValue(roundCount);
    }

    private void runningCars() {
        cars.moveTheCar();
    }

    public List<Car> getCars() {
        return cars.getCars();
    }

}
