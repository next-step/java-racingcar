package racing.controller;

import racing.model.Car;
import racing.view.CliInputView;
import racing.view.CliOutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class CarRacingController {

    private List<Car> cars = new ArrayList<>();
    private int numberOfMove = 0;

    public void start() {
        setInput();
        play();
    }

    private void setInput() {
        int numberOfCar = CliInputView.getNumberOfCarFromCliInput();
        for (int i = 0; i < numberOfCar; i++) {
            cars.add(new Car());
        }
        numberOfMove = CliInputView.getNumberOfMoveFromCliInput();
        System.out.println();
    }

    private void play() {
        CliOutputView.printStartSentence();
        for (int i = 0; i < numberOfMove; i++) {
            cars.forEach(Car::moveRandom);
            CliOutputView.printCars(cars);
        }
    }
}
