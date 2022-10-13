package racinggame.domain.embeded;

public class CarDistance {

    public static final int DEFAULT_CAR_DISTANCE = 0;

    private final int distance;

    public CarDistance(int carDistance) {
        this.distance = carDistance;
    }

    public CarDistance plus() {
        return new CarDistance(distance + 1);
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CarDistance that = (CarDistance) o;

        return distance == that.distance;
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
