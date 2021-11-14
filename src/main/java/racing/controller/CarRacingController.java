package racing.controller;

import racing.model.Car;
import racing.view.TerminalInputView;
import racing.view.TerminalOutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class CarRacingController {

    private final List<Car> cars = new ArrayList<>();
    private int numberOfMove = 0;

    public void start() {
        setInput();
        play();
    }

    private void setInput() {
        List<String> names = TerminalInputView.inputNamesOfCar();
        for (String name : names) {
            Car car = new Car(name);
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
        TerminalOutputView.printWinnersCars(extractWinners());
    }

    private List<Car> extractWinners() {
        int maxDistance = cars.stream()
                .mapToInt(Car::getMovingDistance)
                .max()
                .orElseThrow(() -> new NoSuchElementException("cars 중 maxDistance 를 찾는데 실패하였습니다."));
        return cars.stream()
                .filter(car -> car.getMovingDistance() == maxDistance)
                .collect(Collectors.toList());
    }
}
