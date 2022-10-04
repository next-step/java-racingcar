package game.domain.car;

import game.domain.rule.RacingGameRule;

public abstract class Car {

    protected Location location;
    private String name;

    public Car() {
    }

    public Car(String name) {
        this.name = name;
        this.location = new Location(0);
    }

    public Location location() {
        return new Location(location);
    }

    public String name() {
        return name;
    }

    public abstract void forward(RacingGameRule racingGameRule, int number);

}
