package racinggame.domain.embeded;

public class CarDistance {

    private final int distance;

    public CarDistance(int carDistance) {
        this.distance = carDistance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CarDistance that = (CarDistance) o;

        return distance == that.distance;
    }

    public CarDistance plus() {
        return new CarDistance(distance + 1);
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public int hashCode() {
        return distance;
    }

    @Override
    public String toString() {
        return "CarDistance{" +
                "carDistance=" + distance +
                '}';
    }
}
