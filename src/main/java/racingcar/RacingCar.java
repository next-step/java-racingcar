package racingcar;

import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class RacingCar {
    private Point coordinate = new Point(0, 0);

    public static RacingCar @NotNull [] createBatch(int size) {
        return Stream.generate(RacingCar::new)
                .limit(size)
                .toArray(RacingCar[]::new);
    }

    public void proceed() {
        this.coordinate.setLocation(coordinate.getX() + 1, 0);
    }

    public Point getLocation() {
        return coordinate.getLocation();
    }
}
