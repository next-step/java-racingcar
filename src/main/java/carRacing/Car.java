package carRacing;

import org.assertj.core.util.VisibleForTesting;

import java.util.Random;

public class Car {

    Random random;
    int position;

    public Car() {
        random = new Random();
        this.position = 0;
    }

    public void move() {
        if(movable()) {
            position++;
        }
    }

    @VisibleForTesting
    public boolean movable() {
        return (random.nextInt(Constants.MOVE_PERCENT_DENOMINATOR) >= Constants.MOVE_PERCENT_NUMERATOR);
    }

    public int inquiryPosition() {
        return position;
    }

    @VisibleForTesting
    public void setRandom(Random random) {
        this.random = random;
    }
}
