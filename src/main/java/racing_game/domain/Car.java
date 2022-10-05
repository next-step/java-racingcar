package racing_game.domain;

import racing_game.core.Positive;

public class Car implements Moving {

    private final Moving movingStrategy;

    private Car(Moving movingStrategy) {
        this.movingStrategy = movingStrategy;
    }

    public static Car create(Moving movingStrategy) {
        return new Car(movingStrategy);
    }

    public void move() {
        movingStrategy.move();
    }

    public Positive getDistance() {
        return movingStrategy.getDistance();
    }

}
