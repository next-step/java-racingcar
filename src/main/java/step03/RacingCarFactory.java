package step03;

import java.util.ArrayList;
import java.util.List;

public class RacingCarFactory {
    private List<RacingCar> racingCars;

    RacingCarFactory(String carNames) {
        racingCars = new ArrayList<>();
        makeCars(carNames);
    }

    private void makeCars(String carNames) {
        String[] carNameList = carNames.split(",");
        for (String carName : carNameList) {
            racingCars.add(new RacingCar(carName));
        }
    }

    public void moveCars(MoveStrategy moveStrategy) {
        for (RacingCar car : racingCars) {
            car.tryToMove(moveStrategy);
        }
    }

    public List<RacingCar> getRacingCars() {
        return racingCars;
    }
}
