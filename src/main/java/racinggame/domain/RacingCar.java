package racinggame.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racinggame.view.RacingCarView;

public class RacingCar {

    private static final int MINIMUM_FORWARD_VALUE = 4;

    private final RacingCarView racingCarView = new RacingCarView(this);
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

    public boolean canForward(int randomValue) {
        return randomValue >= MINIMUM_FORWARD_VALUE;
    }

    public void forward() {
        this.carPosition += 1;
    }

    public String drawCurrPosition() {
        return this.racingCarView.drawCurrPosition();
    }

    public int getPosition() {
        return this.carPosition;
    }

    public String getCarName() {
        return this.carName;
    }
}
