package com.nextstep.racingcargame.core;

import java.util.Comparator;
import java.util.Objects;

public class Distance implements Comparator<Distance> {

    private final int distance;

    private static final int MOVE_STEP = 1;

    public Distance(int distance) {
        this.distance = distance;
    }

    public Distance moveForward(int randomNumber) {
        return new Distance(this.distance + MOVE_STEP);
    }

    public String distanceForm(String distancePrintStandard) {
        return distancePrintStandard.repeat(this.distance);
    }

    @Override
    public int compare(Distance d1, Distance d2) {
        return Integer.compare(d1.distance, d2.distance);
    }

    public boolean isLongerThan(Distance other) {
        return compare(this, other) > 0;
    }

    public boolean isSame(Distance distance) {
        return this.equals(distance);
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

}
