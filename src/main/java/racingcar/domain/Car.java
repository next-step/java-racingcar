package racingcar.domain;

import racingcar.strategy.MovingStrategy;

public class Car {
    private final CarName carName;
    private CarPosition position;

    public Car(final String name) {
        this(new CarName(name), new CarPosition(0));
    }

    public Car(final String name, int position) {
        this(new CarName(name), new CarPosition(position));
    }

    public Car(final CarName name, final CarPosition position) {
        this.carName = name;
        this.position = position;
    }

    public CarName getCarName() { return this.carName; }
    public CarPosition getCarPosition() {
        return this.position;
    }

    public void move(MovingStrategy strategy) {
        if(strategy.canMove()) {
            this.position.increasePosition();
        }
    }

    public boolean isWinner(int maxPosition) {
        return this.position.isEqaul(maxPosition);
    }

    public int maxPosition(int maxPositioin) {
        return this.position.maxPosition(maxPositioin);
    }
}
