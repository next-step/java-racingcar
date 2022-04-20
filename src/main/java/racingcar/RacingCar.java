package racingcar;

import java.awt.*;
import java.util.Arrays;
import java.util.stream.Collectors;

public class RacingCar {
    private Point coordinate;
    private String name;

    public RacingCar(String name) {
        this.coordinate = new Point(0, 0);
        this.name = name;
    }

    public static RacingCar[] createBatch(String[] carNames) {
        return Arrays.asList(carNames)
                .stream()
                .map(name -> new RacingCar(name))
                .collect(Collectors.toList())
                .toArray(new RacingCar[carNames.length]);
    }

    public void proceed() {
        this.coordinate.setLocation(coordinate.getX() + 1, 0);
    }

    public Point getLocation() {
        return coordinate.getLocation();
    }

    public String getName() {
        return name;
    }
}
