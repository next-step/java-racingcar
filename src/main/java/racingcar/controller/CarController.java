package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.CarList;
import racingcar.domain.GameNumbers;
import racingcar.util.CarRandom;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarController {
    private CarList carList;
    private GameNumbers gameNumbers;

    public CarController(String[] carNames, int tryCounts) {
        gameNumbers = new GameNumbers(tryCounts);
        initCarList(carNames);
    }

    public CarController(CarList carList) {
        this.carList = carList;
    }

    public CarController(int tryCounts, int round) {
        gameNumbers = new GameNumbers(tryCounts, round);
    }

    public void initCarList(String[] carNames) {
        List<Car> cars = Arrays.stream(carNames)
                .map(Car::from)
                .collect(Collectors.toList());

        carList = CarList.from(cars);
    }

    public boolean isFinish() {
        return gameNumbers.getTryCounts() == gameNumbers.getRound();
    }

    private void racingCarMove() {
        List<Car> cars = carList.getCarList();
        for(Car car : cars) {
            car.move(CarRandom.makeRandomValue());
        }
        carList = CarList.from(cars);
    }

    private void increaseRound() {
        gameNumbers.increaseRound();
    }

    public CarList racing() {
        increaseRound();
        racingCarMove();
        return carList;
    }

    public List<String> getWinners() {
        return carList.getCarList()
                .stream()
                .filter(car -> car.getCurrentPosition() == getWinnerScore())
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    public int getWinnerScore() {
        return carList.getCarList()
                .stream()
                .mapToInt(Car::getCurrentPosition)
                .max()
                .orElseThrow(RuntimeException::new);
    }

    public CarList getCarList() {
        return carList;
    }

}
