package racingcar;

import java.util.Objects;

public class Distance {

    private int distance;

    public Distance() {
        this.distance = 0;
    }

    public Distance(String distance) {
        this(Integer.parseInt(distance));
    }

    public Distance(int distance) {
        this.distance = distance;
    }

    public void goStraight() {
        this.distance++;
    }

    public int findLongestDistance(int longestDistance) {
        return Math.max(distance, longestDistance);
    }

    public boolean isLongestDistance(int longestDistance) {
        return distance == longestDistance;
    }

    public String distanceToString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < distance; i++) {
            sb.append("-");
        }
        return sb.toString();
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
