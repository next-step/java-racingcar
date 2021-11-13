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
        List<String> names = TerminalInputView.inputNamesOfCar();
        for (String name : names) {
            Car car = new Car();
            car.setName(name);
            cars.add(car);
        }
        numberOfMove = TerminalInputView.inputNumberOfMove();
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
