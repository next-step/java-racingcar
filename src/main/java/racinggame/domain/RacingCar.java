package racinggame.domain;

import racinggame.random.RandomNumberGenerator;

public class RacingCar {
    public static final int MOVE_THRESHOLD = 4;

    private final RandomNumberGenerator generator;
    private int position;

    public RacingCar(final RandomNumberGenerator generator) {
        this.generator = generator;
        this.position = 0;
    }

    public void move() {
        if (generator.generate() > MOVE_THRESHOLD) {
            position++;
        }
    }

    public int currentPosition() {
        return position;
    }
}
