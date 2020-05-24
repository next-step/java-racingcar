package edu.next.racing.model;

public class RacingCar extends Car {

    public RacingCar(String name) {
        super(name);
    }

    @Override
    protected boolean isMoveable() {
        return (MOVEABLE_NUMBER <= rand.nextInt(MAX_RANDOM_COUNT));
    }
}
