package step5.domain;

import step5.domain.strategy.MovingStrategy;

public class Car {

    private CarName carName;
    private int position;

    public Car(String name) {
        this.carName = new CarName(name);
    }

    public void move(MovingStrategy movingStrategy) {
        if (movingStrategy.isMove()) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return carName.getName();
    }

}
