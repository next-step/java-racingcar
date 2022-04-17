package racingcar;

import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.util.stream.IntStream;

public class RacingCar {
    private Point coordinate = new Point(0, 0);

    public static RacingCar @NotNull [] createBatch(int size) {
        RacingCar[] racingCars = new RacingCar[size];
        IntStream.range(0, size).forEach(i ->
                racingCars[i] = new RacingCar()
        );
        return racingCars;
    }

    public void proceed() {
        this.coordinate.setLocation(coordinate.getX() + 1, 0);
    }

    public Point getLocation() {
        return coordinate.getLocation();
    }
}
