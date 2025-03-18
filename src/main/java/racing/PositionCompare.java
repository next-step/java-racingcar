package racing;

public class PositionCompare {
    private final String carName;
    private final int nowPosition;
    private final int maxPosition;

    public PositionCompare(String carName, int nowPosition, int maxPosition) {
        this.carName = carName;
        this.nowPosition = nowPosition;
        this.maxPosition = maxPosition;
    }

    public boolean isMaxPosition() {
        return nowPosition == maxPosition;
    }

    public String getCarName() {
        return carName;
    }
}
