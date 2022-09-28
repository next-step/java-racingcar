package game.domain.car;

import game.domain.RacingGameRule;

public abstract class Car {

    protected int location;
    private String name;

    public Car() {
    }

    public Car(String name) {
        this.name = name;
    }

    public int location() {
        return location;
    }

    public String name() {
        return name;
    }

    public abstract void forward(RacingGameRule racingGameRule);

}
