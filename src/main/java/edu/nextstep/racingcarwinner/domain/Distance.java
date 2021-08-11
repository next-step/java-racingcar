package edu.nextstep.racingcarwinner.domain;

import java.util.Objects;

public class Distance {
    private final int distance;

    public Distance(int distance) {
        if(distance < 0){
            throw new IllegalArgumentException("자동차 이동거리는 0 이상이어야 합니다.");
        }
        this.distance = distance;
    }

    public Distance move() {
        return new Distance(this.distance + 1);
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Distance distance1 = (Distance) o;
        return distance == distance1.distance;
    }

    @Override
    public int hashCode() {
        return Objects.hash(distance);
    }
}
