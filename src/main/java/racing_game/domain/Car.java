package racing_game.domain;

import java.util.Random;
import racing_game.core.Positive;

public class Car {

    private final Random random;
    private final Positive distance; // time x distance - 시간 대별(회차) 거리

    private Car(Random random) {
        this.distance = Positive.zero();
        this.random = (random == null) ? new Random() : random;
    }

    public static Car create() {
        return new Car(null);
    }

    public static Car create(Random random) {
        return new Car(random);
    }

    public void move() {
        if (canMove()) {
            distance.addOne();
        }
    }

    private boolean canMove() {
        return random.nextInt(10) >= 4;
    }

    public Positive getDistance() {
        return Positive.copy(distance);
    }

}
