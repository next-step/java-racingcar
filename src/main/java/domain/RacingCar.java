package domain;

import movingStrategy.Moveable;

public class RacingCar {
    private final String name;
    private Integer position;
    private final Moveable moveable;

    public RacingCar(String name, Moveable moveable) {
        this.name = name;

        this.position = 0;
        this.moveable = moveable;
    }

    public Integer whereIsCar() {
        return this.position;
    }

    public void move() {
        if (moveable.isMoveable()) {
            this.position++;
        }
    }

    public String whatIsYourName() {
        return this.name;
    }

    public RacingCarCurrentStatus getCurrentStatus() {
        return new RacingCarCurrentStatus(this.name, this.position);
    }
}
