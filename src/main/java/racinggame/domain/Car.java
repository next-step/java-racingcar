package racinggame.domain;

import racinggame.domain.embeded.CarDistance;
import racinggame.domain.embeded.CarName;
import racinggame.domain.strategy.MoveStrategy;
import racinggame.domain.strategy.RandomMoveStrategy;
import racinggame.util.RandomUtils;

import static racinggame.domain.embeded.CarDistance.DEFAULT_CAR_DISTANCE;
import static racinggame.domain.strategy.RandomMoveStrategy.DEFAULT_GENERATE_STRATEGY;

public class Car {

    private MoveStrategy moveStrategy;

    private CarDistance carDistance;
    private final CarName carName;

    public Car(String carName) {
        this(carName, DEFAULT_CAR_DISTANCE);
    }

    public Car(String carName, int carDistance) {
        this(carName, carDistance, new RandomMoveStrategy(DEFAULT_GENERATE_STRATEGY));
    }

    public Car(String name, int carDistance, MoveStrategy moveStrategy) {
        if (moveStrategy == null) {
            throw new IllegalArgumentException("이동 전략을 필수값 입니다.");
        }

        this.moveStrategy = moveStrategy;
        this.carName = new CarName(name);
        this.carDistance = new CarDistance(carDistance);
    }

    public CarDistance getCarDistance() {
        return this.carDistance;
    }

    public CarName getCarName() {
        return this.carName;
    }

    public void move() {
        if (!moveStrategy.movable()) {
            return;
        }

        this.carDistance = carDistance.plus();
    }


}
