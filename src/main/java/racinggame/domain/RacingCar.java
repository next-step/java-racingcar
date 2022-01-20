package racinggame.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCar {

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

    public void forward() {
        this.carPosition += 1;
    }

    public void printCurrPosition() {
        String dash = Utils.repeat("-", carPosition);
        System.out.print(String.format("%-5s: %s", carName, dash));
    }
}
