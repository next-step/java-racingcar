package game.domain.car;

import game.domain.rule.RacingGameRule;

public abstract class Car {

    protected Location location;
    private CarName carName;

    public Car() {
    }

    public Car(String name) {
        this.carName = new CarName(name);
        this.location = new Location(0);
    }

    public Location location() {
        return new Location(location);
    }

    public CarName carName() {
        return new CarName(carName);
    }

    public abstract void forward(RacingGameRule racingGameRule, int number);

}
