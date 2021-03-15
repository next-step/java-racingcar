package step03;

import java.util.ArrayList;
import java.util.List;

public class RacingCarFactory {
    private List<RacingCar> racingCars = new ArrayList<>();

    public RacingCarFactory() {}

    public void makeCars(int carCount) {
        for (int i = 0; i < carCount; i++) {
            racingCars.add(new RacingCar());
        }
    }

    public void racing(int tryCount) {
        for (int i = 0; i < tryCount; i++) {
            moveCars();
        }
    }

    private void moveCars() {
        for (RacingCar car : racingCars) {
            car.tryToMove();
        }
    }
}
