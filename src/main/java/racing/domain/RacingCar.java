package racing.domain;

import racing.util.DefaultRandomNumberProvider;
import racing.util.RandomNumberProvider;

public class RacingCar {
    static RandomNumberProvider RANDOM_PROVIDER = new DefaultRandomNumberProvider();
    private int position;

    public RacingCar() {
        this.position = 0;
    }

    public void rush() {
        if (RANDOM_PROVIDER.getRandomNumber() >= 4)
            position += 1;
    }

    public int getPosition() {
        return position;
    }
}
