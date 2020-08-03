package racing.domain;

import static racing.domain.CarRacingProperty.MIN_MOVABLE_DISTANCE;

public class Car {

    private int distance = 0;

    public void move(int distance) {
        if (distance >= MIN_MOVABLE_DISTANCE) {
            this.distance++;
        }
    }

    public int getDistance() {
        return distance;
    }

}
