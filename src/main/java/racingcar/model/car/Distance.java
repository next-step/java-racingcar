package racingcar.model.car;

public class Distance implements Comparable<Distance> {
    private static final int DEFAULT_DISTANCE = 0;
    public static Distance ZERO = new Distance(0);
    private int distance;

    public Distance() {
        this.distance = DEFAULT_DISTANCE;
    }

    public Distance(int distance) {
        this.distance = distance;
    }

    public void move(int amount) {
        this.distance += amount;
    }

    public int intValue() {
        return this.distance;
    }

    @Override
    public int compareTo(Distance o) {
        return Integer.compare(this.distance, o.distance);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof Distance) {
            Distance distance = (Distance) o;
            return this.distance == distance.distance;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return distance;
    }
}
