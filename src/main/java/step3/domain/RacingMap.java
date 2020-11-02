package step3.domain;

public class RacingMap {
    private final int[] location;

    public RacingMap(final int numberOfCar) {
        this.location = new int[numberOfCar];
    }

    private RacingMap(final int[] location) {
        this.location = location;
    }

    public void move(final int id, final int unitOfForward) {
        location[id] += unitOfForward;
    }

    public RacingMap clone() {
        return new RacingMap(location.clone());
    }

    public int findPosition(final int id) {
        return location[id];
    }
}
