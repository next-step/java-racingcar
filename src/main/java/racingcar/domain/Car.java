package racingcar.domain;

import racingcar.domain.input.CarName;
import racingcar.domain.strategy.MovingStrategy;
import racingcar.domain.strategy.RandomMoving;

public class Car {

    private static final int INITIAL_POSITION = 0;

    private int position;
    private final CarName carName;
    private final MovingStrategy strategy;

    public Car(String carName) {
        this(new CarName(carName), new RandomMoving());
    }

    public Car(CarName carName) {
        this(carName, new RandomMoving());
    }

    public Car(String carName, MovingStrategy strategy) {
        this(new CarName(carName), strategy);
    }

    public Car(CarName carName, MovingStrategy strategy) {
        this.position = INITIAL_POSITION;
        this.carName = carName;
        this.strategy = strategy;
    }

    public Car(Car car) {
        this.position = car.position;
        this.carName = car.carName;
        this.strategy = car.strategy;
    }

    public void move() {
        if (!strategy.isMoving()) {
            return;
        }
        go();
    }

    private void go() {
        this.position++;
    }

    public int getPosition() {
        return this.position;
    }

    public String getCarName() {
        return this.carName.getCarName();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Car)) {
            return false;
        }
        Car c = (Car) obj;
        return c.carName.equals(carName) && c.position == (position);
    }
}
