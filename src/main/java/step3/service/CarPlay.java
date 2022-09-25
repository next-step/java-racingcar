package step3.service;

import java.util.List;

import step3.domain.Car;

public class CarPlay {

    private final Car car;

    public CarPlay(Car car) {
        this.car = car;
    }

    public List<Integer> carMovement() {

        List<Integer> newCarList = car.renewedCarList();

        for (int i = 0; i < car.getCars(); i++) {
            if (car.isAddMoveCount())
                newCarList.set(i, newCarList.get(i) + 1);
        }
        return newCarList;
    }
}
