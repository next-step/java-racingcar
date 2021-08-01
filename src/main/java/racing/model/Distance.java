package racing.model;

public class Distance {

    private int distance;

    public Distance(int distance) {
        this.distance = distance;
    }

    public int getDistance() {
        return this.distance;
    }

    public Distance forward() {
        return new Distance(++distance);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Distance distance1 = (Distance) o;

        return distance1.distance == this.distance;
    }
}
