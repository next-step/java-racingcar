package racingCar;

import static racingCar.MoveStrategy.MAX_DISTANCE;
import static racingCar.MoveStrategy.MIN_DISTANCE;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class RacingCar {

    private static final int START_LOCATION = 0;
    private int location;

    public RacingCar() {
        this.location = START_LOCATION;
    }

    public int findCurrentLocation() {
        return this.location;
    }

    public void move(boolean isMovable) {
        if (isMovable) {
            this.location++;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < location; i++) {
            sb.append("-");
        }
        return sb.toString();
    }
}
