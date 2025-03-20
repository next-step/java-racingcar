package domain;

import movingStrategy.Moveable;

public class RacingCar {
    private final Moveable moveable;
    private Integer position;

    public RacingCar(Moveable moveable) {
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
}
