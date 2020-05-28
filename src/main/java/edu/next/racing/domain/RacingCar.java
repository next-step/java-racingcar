package edu.next.racing.domain;

public class RacingCar extends Car implements CarInterface {

    public RacingCar(String name) {
        super(name);
    }

    @Override
    public boolean isMoveable() {
        return (MOVEABLE_NUMBER <= rand.nextInt(MAX_RANDOM_COUNT));
    }
}
