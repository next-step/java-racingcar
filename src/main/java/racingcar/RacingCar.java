package racingcar;

import java.awt.*;
import java.util.Arrays;
import java.util.stream.Collectors;

public class RacingCar {
    private Point coordinate;
    private CarName carName;

    public RacingCar(CarName carName) {
        this(carName, new Point(0, 0));
    }

    public RacingCar(CarName carName, Point coordinate) {
        this.coordinate = coordinate;
        this.carName = carName;
    }

    public static RacingCar[] createBatch(String[] carNames) {
        return Arrays.asList(carNames)
                .stream()
                .map(name -> new RacingCar(new CarName(name)))
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
        return carName.getName();
    }
}
