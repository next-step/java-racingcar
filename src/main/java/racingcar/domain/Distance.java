package racingcar.domain;

public class Distance {
    private int distance;

    public Distance() {
        this.distance = 0;
    }

    public void increase() {
        this.distance++;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Distance)) return false;

        Distance distance1 = (Distance) o;
        return distance == distance1.distance;
    }

    @Override
    public int hashCode() {
        return distance;
    }
}
