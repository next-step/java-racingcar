package racinggame.domain;

import static racinggame.domain.Constants.*;

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
        return Arrays.stream(carNames).map(RacingCar::new)
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
        View.printCarStatus(this.carName, this.carPosition);
    }
}
