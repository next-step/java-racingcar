package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class RacingCar {
    private final String carName;
    private static final int INIT_DIST = 0;
    private int carDist;
    private final MoveCar moveCar;

    private RacingCar(String carName, MoveCar moveCar) {
        this.carName = carName;
        carDist = INIT_DIST;
        this.moveCar = moveCar;
    }

    public static List<RacingCar> setRacingCars(List<String> carNames) {

        return carNames.stream()
            .map(carName1 -> new RacingCar(carName1, new MoveCar()))
            .collect(Collectors.toList());
    }

    public void moveCar() {
        if (moveCar.isMove()) {
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
