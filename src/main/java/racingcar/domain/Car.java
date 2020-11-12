package racingcar.domain;

import racingcar.domain.utils.Number;

public class Car {
    private String name;
    private String place;
    private MovingStrategy movingStrategy;

    public Car(String name, MovingStrategy movingStrategy) {
        this.name = name;
        this.place = "";
        this.movingStrategy = movingStrategy;
    }

    public String getPlace() {
        return this.place;
    }

    public String getName() {
        return this.name;
    }

    public void move() {
        if (this.movingStrategy.move() >= Number.NEED_NUMBER) {
            movePlace();
        }
    }

    private void movePlace() {
        this.place += new StringBuilder().append('-');
    }
}
