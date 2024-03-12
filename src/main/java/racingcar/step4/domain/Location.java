package racingcar.step4.domain;

import racingcar.step4.utils.ConstUtils;

public class Location {

    private final int location;

    public Location() {
        this(0);
    }

    public Location(int location) {
        this.location = location;
    }

    public Location move() {
        return new Location(this.location + ConstUtils.MOVE);
    }

    public int currentLocation() {
        return this.location;
    }
}
