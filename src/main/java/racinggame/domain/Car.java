package racinggame.domain;

import racinggame.domain.embeded.CarDistance;
import racinggame.domain.embeded.CarName;
import racinggame.domain.strategy.MoveStrategy;
import racinggame.domain.strategy.RandomMoveStrategy;
import racinggame.util.RandomUtils;

public class Car {

    private MoveStrategy moveStrategy;

    private CarDistance carDistance;
    private final CarName carName;

    public Car(String name, CarDistance carDistance) {
        this(name, carDistance, new RandomMoveStrategy((randomNumber) -> RandomUtils.randomNumber(randomNumber)));
    }

    public Car(String name, CarDistance carDistance, MoveStrategy moveStrategy) {
        if (moveStrategy == null) {
            throw new IllegalArgumentException("이동 전략을 필수값 입니다.");
        }

        this.moveStrategy = moveStrategy;
        this.carName = new CarName(name);
        this.carDistance = carDistance;
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
