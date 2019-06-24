package com.mommoo.step2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private static final int INIT_POSITION = 0;
    private final List<Car> CAR_LIST;

    public RacingGame(String[] carNames) {
        this.CAR_LIST = convertToCarList(carNames);
    }

    private List<Car> convertToCarList(String[] carNames) {
        return Arrays.stream(carNames)
                .map(carName -> new Car(carName, INIT_POSITION))
                .collect(Collectors.toList());
    }

    public List<Car> move() {
        List<Car> nextCarList = new ArrayList<>();
        for(Car currentCar : CAR_LIST) {
            Car nextCar = RacingCarMovingConditioner.isMoveCondition() ? currentCar.nextPositionCar() : currentCar;
            nextCarList.add(nextCar);
        }

        CAR_LIST.clear();
        CAR_LIST.addAll(nextCarList);

        return nextCarList;
    }

    public List<Car> currentCarList() {
        return Collections.unmodifiableList(CAR_LIST);
    }
}
