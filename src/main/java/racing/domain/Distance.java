package racing.domain;

import java.util.Objects;

public class Distance {
    public static final Distance zero = new Distance(0);

    public static final Distance one = new Distance(1);

    private final int distance;

    private Distance(int distance){
        this.distance = distance;
    }

    public Distance plus(Distance distance) {
        return new Distance(this.distance + distance.distance);
    }

    public int getDistance(){
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
