package com.ssabae.nextstep.racingcar.step03.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * @author : leesangbae
 * @project : java-racingcar
 * @since : 2020-12-06
 */
public class Cars {

    private static final int MIN_RANDOM_VALUE = 0;
    private static final int MAX_RANDOM_VALUE = 9;
    private static final int MOVEMENT_MIN_VALUE = 4;

    private final List<Car> carList;
    private final Operator<MoveState> operator;
    private final Random random;

    public Cars(Random random, String names) {
        this.carList = new ArrayList<>();
        this.operator = new MoveOperator(MIN_RANDOM_VALUE, MAX_RANDOM_VALUE, MOVEMENT_MIN_VALUE);
        this.random = random;
        addCarList(splitCarNames(names));
    }

    private List<String> splitCarNames(String names) {
        return Arrays.asList(names.split(","));
    }

    private void addCarList(List<String> names) {
        names.forEach(name -> carList.add(new Car(name)));
    }

    public void moving() {
        for (Car car : carList) {
            int randomNumber = random.nextInt(MAX_RANDOM_VALUE + 1);
            MoveState operate = operator.operate(randomNumber);
            car.move(operate);
        }
    }

    public List<Car> getCarList() {
        return Collections.unmodifiableList(carList);
    }

    public String getWinnerNames() {
        int maxMoveCount = getMaxMoveCount();
        return carList.stream()
                .filter(car -> car.getMoveCount() == maxMoveCount)
                .map(Car::getName)
                .collect(Collectors.joining(","));
    }

    private int getMaxMoveCount() {
        return carList.stream()
                .map(Car::getMoveCount)
                .max(Comparator.comparingInt(o -> o))
                .orElse(0);
    }
}
