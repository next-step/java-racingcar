package game.domain;

public abstract class Car {

    protected int location;

    public int location() {
        return location;
    }

    public abstract void forward(RacingGameRule racingGameRule);

}
