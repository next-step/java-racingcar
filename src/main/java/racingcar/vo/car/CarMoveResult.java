package racingcar.vo.car;

public class CarMoveResult {
    private final String name;
    private final int location;

    public CarMoveResult(String name, int location) {
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public int getLocation() {
        return location;
    }

    public boolean isSameLocation(final int targetLocation) {
        return this.location == targetLocation;
    }
}
