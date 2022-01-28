package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class RacingCar {

    private int carDist;

    private final String carName;
    private static final int INIT_DIST = 0;

    private static final MovingCar moveCar = new MovingCar();

    private RacingCar(String carName) {
        this.carName = carName;
        carDist = INIT_DIST;
    }

    public static List<RacingCar> setRacingCars(List<String> carNames) {
        return carNames.stream()
            .map(RacingCar::new)
            .collect(Collectors.toList());
    }

    public void moveCar(int number) {
        if (moveCar.isMove(number)) {
            carDist++;
        }
    }

    public String getCarName() {
        return carName;
    }

    public int getCarDist() {
        return carDist;
    }
}
