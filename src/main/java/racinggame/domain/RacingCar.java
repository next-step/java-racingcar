package racinggame.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCar {

    private static final int MOVING_SPACES = 1;

    private String carName;
    private int carPosition = 0;

    private RacingCar() {}

    public RacingCar(String carName) {
        this.carName = carName;
    }

    public static List<RacingCar> createRacingCarFromCarNames(String[] carNames) {
        return Arrays.stream(carNames).map(carName -> new RacingCar(carName))
                .collect(Collectors.toList());
    }

    public String getCarName() {
        return this.carName;
    }

    public int getPosition() {
        return this.carPosition;
    }

    public void moveForward() {
        this.carPosition += MOVING_SPACES;
    }

    public void printCurrPosition() {
        String dash = Utils.repeat("-", carPosition);
        System.out.println(String.format("%-5s: %s", carName, dash));
    }
}
