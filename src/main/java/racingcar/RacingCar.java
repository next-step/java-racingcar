package racingcar;

import java.awt.*;
import java.util.Arrays;
import java.util.stream.Collectors;

public class RacingCar {
    private Point coordinate;
    private String name;

    public RacingCar(String name) {
        this(name, new Point(0, 0));
    }

    public RacingCar(String name, Point coordinate) {
        this.coordinate = coordinate;
        this.name = name;
    }

    public static RacingCar[] createBatch(String[] carNames) {
        validateCarNames(carNames);
        return Arrays.asList(carNames)
                .stream()
                .map(name -> new RacingCar(name))
                .collect(Collectors.toList())
                .toArray(new RacingCar[carNames.length]);
    }

    private static void validateCarNames(String[] carNames) {
        for (String carName : carNames) {
            validateLength(carName);
        }

    }

    private static void validateLength(String carName) throws IllegalStateException {
        if (carName.length() > 5) {
            throw new IllegalStateException("자동차 이름은 5자를 초과할 수 없습니다.");
        }

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
