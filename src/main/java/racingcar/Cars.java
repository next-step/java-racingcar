package racingcar;

import racingcar.movablestrategy.MovableStrategy;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private List<Car> cars = new ArrayList<Car>();

    public Cars(int carCount) {
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car());
        }
    }

    public Cars(int carCount, MovableStrategy movableStrategy) {
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car(movableStrategy));
        }
    }

    public boolean carsReady(int racingCondition) {
        return cars.size() >= racingCondition;
    }

    public void race(int roundCount) {
        for (int i = 0; i < roundCount; i++) {
            for(Car car : cars) {
                car.move();
                car.positionPrint();
            }
            ResultView.roundFinish();
        }
    }
}
