package racinggame.domain;

public class CarDistance {

    private final int carDistance;

    public CarDistance(int carDistance) {
        this.carDistance = carDistance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CarDistance that = (CarDistance) o;

        return carDistance == that.carDistance;
    }

    @Override
    public int hashCode() {
        return carDistance;
    }

    @Override
    public String toString() {
        return "CarDistance{" +
                "carDistance=" + carDistance +
                '}';
    }
}
