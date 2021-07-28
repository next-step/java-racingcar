package racingcar;

public class Lap {
    private final Distances distances;

    public Lap(Cars cars) {
        this.distances = new Distances(cars);
    }

    public Distances getDistances() {
        return distances;
    }
}
