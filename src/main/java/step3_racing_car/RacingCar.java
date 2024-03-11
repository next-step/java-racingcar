package step3_racing_car;

import java.util.Random;

public class RacingCar {
    int position = 0;

    public int getPosition() {
        return position;
    }

    public void movePositions(int distance) {
        this.position += distance;
    }
}
