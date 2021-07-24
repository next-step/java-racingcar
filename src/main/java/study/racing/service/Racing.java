package study.racing.service;

import static study.racing.common.Message.MSG_ROUND_RESULT;
import static study.racing.view.InsertView.printMessage;

import java.util.List;
import study.racing.domain.Car;
import study.racing.domain.Cars;
import study.racing.view.DrawDisplay;

public class Racing {

    private Cars cars;

    public Racing(String carsName, int roundCount) {
        this.cars = createCars(carsName);
        playingRounds(roundCount);
    }

    public Racing(int carCount, int roundCount) {
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

    private Cars createCars(String carsName) {
        return new Cars(carsName);
    }

    private void runningCars() {
        cars.moveTheCar();
    }

    public List<Car> getCars() {
        return cars.getCars();
    }

    public List<Car> getWinnersName() {
        return cars.getWinners();
    }
}
