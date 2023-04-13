package com.nextstep.racingcargame.core;

import java.util.Comparator;
import java.util.Objects;

public class Distance implements Comparator<Distance> {

    private int distance;

    private static final int MINIMUM_CAR_MOVE_NUMBER = 4;

    private static final int MOVE_STEP = 1;

    public Distance(int distance) {
        this.distance = distance;
    }

    public void moveForward(int randomNumber) {
        if (isGoForwardNumber(randomNumber)) {
            this.distance += MOVE_STEP;
        }
    }

    public String distanceForm(String distancePrintStandard) {
        return distancePrintStandard.repeat(this.distance);
    }

    private boolean isGoForwardNumber(int randomNumber) {
        return randomNumber >= MINIMUM_CAR_MOVE_NUMBER;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Distance distance1 = (Distance) o;
        return distance == distance1.distance;
    }

    @Override
    public int hashCode() {
        return Objects.hash(distance);
    }

    @Override
    public int compare(Distance d1, Distance d2) {
        return Integer.compare(d1.distance, d2.distance);
    }

    public boolean isGreaterThan(Distance other) {
        return compare(this, other) > 0;
    }
}
