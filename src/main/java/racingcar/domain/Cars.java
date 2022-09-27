package racingcar.domain;

import racingcar.strategy.MovingStrategy;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private List<Car> carRacing = new ArrayList<>();

    public Cars(int carCount) {
        for (int i = 0; i < carCount; i++) {
            carRacing.add(new Car());
        }
    }

    public void move(int tryCount, MovingStrategy movingStrategy) {
        for (int i = 0; i < tryCount; i++) {
            Car car = new Car();
            car.move(movingStrategy);
            if (car.equals(new Car(1))) {
                System.out.print("-");
            }
        }
        System.out.println();
    }
}
