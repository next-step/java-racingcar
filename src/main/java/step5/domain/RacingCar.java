package step5.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class RacingCar {

    private static final int DEFAULT_POSITION = 0;

    private final String name;
    private int position;

    public RacingCar(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public static RacingCar ready(String name) {
        return new RacingCar(name, DEFAULT_POSITION);
    }

    public boolean isMaxPosition(int maxPosition) {
        return position == maxPosition;
    }

    public int forward() {
        return ++position;
    }

    public int currentPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public int comparePosition(final RacingCar racingCar) { return position - racingCar.position; }
}
