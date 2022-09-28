package com.game.racing.car;

import com.game.racing.generator.NumberGenerator;
import com.game.racing.position.Position;
import com.game.racing.view.ResultView;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class Cars {

    /**
     * 자동차를 움직일 수 있는 최소 기준값
     */
    public static final Integer MIN_VALUE_TO_MOVE_CAR = 4;

    private static final String CAR_NAMES_SEPARATOR = ",";

    private final LinkedHashMap<String, Car> cars;
    private List<Car> racingWinners;

    private final NumberGenerator numberGenerator;

    public Cars(String carNames, NumberGenerator numberGenerator) {
        this.cars = new LinkedHashMap<>();
        addNewCarsWithNames(carNames);
        this.numberGenerator = numberGenerator;
    }

    public Integer getTotalCarSize() {
        return cars.size();
    }

    public Car getCarByName(String name) {
        return cars.get(name);
    }

    private void addNewCarsWithNames(String carNames) {
        String[] splittedCarNames = carNames.split(CAR_NAMES_SEPARATOR);
        for (String carName : splittedCarNames) {
            validateCarName(carName);
            this.cars.put(carName, new Car(carName));
        }
    }

    private void validateCarName(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다!");
        }
    }

    public void moveCars() {
        for (String carName : cars.keySet()) {
            moveCarByGeneratedValue(cars.get(carName));
        }
        ResultView.printNewLine();
    }

    /**
     * 개별 자동차를 IntegerGenerator 를 통해 판별값에 따라 움직이고, 위치를 -(dash)로 출력하는 메소드
     *
     * @param car 개별 자동차
     */
    public void moveCarByGeneratedValue(Car car) {
        if (numberGenerator.generate() >= MIN_VALUE_TO_MOVE_CAR) {
            car.move();
        }
        ResultView.printCarNameAndPosition(car);
    }

    public List<Car> getRacingWinners() {
        racingWinners = new ArrayList<>();
        for (String carName : cars.keySet()) {
            addRacingWinners(cars.get(carName));
        }
        return racingWinners;
    }

    private void addRacingWinners(Car car) {
        if (car.getPosition().get() == Position.getMaxValue()) {
            racingWinners.add(car);
        }
    }
}
