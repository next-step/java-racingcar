package racingcar;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Car {
    private int position;
    private static final String DISTANCE_UNIT = "-";

    public void move() {
        this.position += 1;
    }

    @Override
    public String toString() {
        return IntStream.range(0, position)
                .mapToObj(i -> DISTANCE_UNIT)
                .collect(Collectors.joining());
    }
}
