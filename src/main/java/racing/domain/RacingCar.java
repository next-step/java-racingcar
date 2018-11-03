package racing.domain;

import racing.util.DefaultRandomNumberProvider;
import racing.util.RandomNumberProvider;

public class RacingCar {
    public static final int MOVE_BOUND_VALUE = 4;
    static RandomNumberProvider RANDOM_PROVIDER = new DefaultRandomNumberProvider();
    private int position;

    public RacingCar() {
        this.position = 0;
    }

    public int rush() {
        if (RANDOM_PROVIDER.getRandomNumber() >= MOVE_BOUND_VALUE) {
            position += 1;
        }

        return position;
    }

    public int getPosition() {
        return position;
    }
}
