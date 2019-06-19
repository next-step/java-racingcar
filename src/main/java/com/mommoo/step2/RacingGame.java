package com.mommoo.step2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class RacingGame {
    private static final int INIT_POSITION = 0;
    private final List<Car> CAR_LIST = new LinkedList<>();
    private final RacingCarMovingConditioner movingConditioner = new RacingCarMovingConditioner();

    public RacingGame(String[] carNames) {
        for (String carName : carNames) {
            Car car = new Car(carName, INIT_POSITION);
            CAR_LIST.add(car);
        }
    }

    private Car createNextPositionCar(Car car) {
        String carName = car.getName();
        int nextPosition = car.getPosition() + 1;
        return new Car(carName, nextPosition);
    }

    public List<Car> move() {
        List<Car> nextCarList = new ArrayList<>();
        for(Car currentCar : CAR_LIST) {
            Car nextCar = movingConditioner.isMoveCondition() ? createNextPositionCar(currentCar) : currentCar;
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
