package racingcar;

import java.awt.*;
import java.util.Arrays;
import java.util.stream.Collectors;

public class RacingCar {
    private int location;
    private CarName carName;

    public RacingCar(CarName carName) {
        this(carName, 0);
    }

    public RacingCar(CarName carName, int location) {
        this.location = location;
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
        this.location += 1;
    }

    public int getLocation() {
        return location;
    }

    public String getName() {
        return carName.getName();
    }
}
