package racingcar.domain;

public record CarSnapshot(String name, int distance) {
    public CarSnapshot(CarName name, CarDistance distance) {
        this(name.value(), distance.getValue());
    }

    public boolean hasSameDistance(int otherDistance) {
        return this.distance == otherDistance;
    }
}
