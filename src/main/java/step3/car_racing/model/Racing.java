package step3.car_racing.model;

import step3.car_racing.util.RandomUtil;

import java.util.ArrayList;
import java.util.List;

import static step3.car_racing.util.RandomUtil.*;

public class Racing {

    public void race(Integer carSize, Integer racingCount) {
        List<Car> carList = makeCarList(carSize);

        for (int i = 0; i < racingCount; i++) {
            carList.forEach(this::printCarDistance);
            System.out.println();
        }
    }

    private List<Car> makeCarList(Integer listSize) {
        List<Car> carList = new ArrayList<>();

        for (int i = 0; i < listSize; i++) {
            carList.add(new Car());
        }

        return carList;
    }

    private void printCarDistance(Car car) {
        if (isForward()) {
            car.moveForward();
        }

        System.out.println(car.getDistance());
    }

}
