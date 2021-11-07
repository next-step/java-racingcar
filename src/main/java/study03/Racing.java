package study03;

import java.util.LinkedList;
import java.util.Optional;

/*
*
* Racing
*
* @version 1.0.0
*
* 2021-11-07
*
* Copyright tnals1422
*/
public class Racing {
    private final LinkedList<Car> cars = new LinkedList<>();
    private final int tryCount;

    public Racing(String carCount, String tryCount) {
        for (int i = 1; i <= Integer.parseInt(carCount); i++) {
            this.cars.add(new Car());
        }
        this.tryCount = Integer.parseInt(tryCount);
    }

    public void start() {
        for (int i = 1; i <= tryCount; i++) {
            for (Car car : cars) {
                Optional.ofNullable(car.moveByCondition()).ifPresent(car::moveForward);
            }
            
        }
    }
}
