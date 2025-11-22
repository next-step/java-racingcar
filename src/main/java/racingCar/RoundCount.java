package racingCar;

import java.util.Objects;

public class RoundCount {
    private final int count;
    public RoundCount(int count) {
        this.count = count;
    }

    public int value() {
        return this.count;
    }
}
