package racing.controller;

import racing.model.Car;
import racing.view.TerminalInputView;
import racing.view.TerminalOutputView;

import java.util.ArrayList;
import java.util.List;

public class CarRacingController {

    private List<Car> cars = new ArrayList<>();
    private int numberOfMove = 0;

    public void start() {
        setInput();
        play();
    }

    private void setInput() {
        int numberOfCar = TerminalInputView.getNumberOfCarFromTerminalInput();
        for (int i = 0; i < numberOfCar; i++) {
            cars.add(new Car());
        }
        numberOfMove = TerminalInputView.getNumberOfMoveFromTerminalInput();
        System.out.println();
    }

    private void play() {
        TerminalOutputView.printStartSentence();
        for (int i = 0; i < numberOfMove; i++) {
            cars.forEach(Car::moveRandom);
            TerminalOutputView.printCars(cars);
        }
    }
}
