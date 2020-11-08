package study.racingcar.car;

public class CarSnapshot {

    private final String name;
    private final int currentPosition;

    public CarSnapshot(String name, int currentPosition) {
        this.name = name;
        this.currentPosition = currentPosition;
    }

    public String getName() {
        return name;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }
}
