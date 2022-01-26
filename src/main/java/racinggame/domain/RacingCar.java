package racinggame.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racinggame.view.InputView;
import racinggame.view.CarResultView;

public class RacingCar {

    private static final int MINIMUM_FORWARD_VALUE = 4;
    private static final int INIT_POSITION = 0;

    private final CarResultView carResultView;
    private String carName;
    private int carPosition;

    private RacingCar(String carName) {
        this(carName, INIT_POSITION);
    }

    public RacingCar(String carName, int position) {
        Validator.validateNameLength(carName);

        this.carName = carName;
        this.carPosition = position;
        carResultView = new CarResultView(this);
    }

    public static List<RacingCar> racingCarOf(String[] carNames) {
        List<RacingCar> racingCars;
        while (true) {
            try {
                racingCars = createRacingCars(carNames);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                carNames = InputView.getCarNames();
            }
        }

        return racingCars;
    }

    private static List<RacingCar> createRacingCars(String[] carNames) {
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
        return this.carResultView.drawCurrResult();
    }

    public int getPosition() {
        return this.carPosition;
    }

    public String getCarName() {
        return this.carName;
    }
}
