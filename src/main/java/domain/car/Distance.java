package domain.car;

public class Distance {

    private int distance;

    public Distance() {
        this.distance = 0;
    }

    public int value() {
        return this.distance;
    }

    public void incrementDistance() {
        this.distance++;
    }

    public boolean isMax(Max max) {
        return max.equals(new Max(distance));
    }
}
