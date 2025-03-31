package domain;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {
    private final List<RacingCar> racingCars;

    public RacingCars(List<RacingCar> racingCars) {
        this.racingCars = racingCars;
    }

    public RacingCars(RacingCarNames racingCarNames) {
        this.racingCars = initializeRacingCars(racingCarNames);
    }

    public RacingCars moveRacingCars(List<Boolean> moveable) {
        List<RacingCar> movedRacingCars = new ArrayList<>();
        for (int i = 0; i < racingCars.size(); i++ ) {
            RacingCar racingCar = racingCars.get(i);
            movedRacingCars.add(moveIfAble(moveable.get(i), racingCar));
        }
        return new RacingCars(movedRacingCars);
    }

    private RacingCar moveIfAble(boolean moveable, RacingCar racingCar) {
        if (moveable) {
            return racingCar.move();
        }
        return racingCar;
    }

    public List<RacingCarCurrentStatus> listCurrentRacingCarStatuses() {
        List<RacingCarCurrentStatus> currentStatus = new ArrayList<>();
        for (RacingCar car : racingCars) {
            currentStatus.add(car.getCurrentStatus());
        }
        return currentStatus;
    }

    private List<RacingCar> initializeRacingCars(RacingCarNames racingCarNames) {
        List<RacingCar> racingCars = new ArrayList<>();
        for (String name : racingCarNames.getRacingCarNames()) {
            racingCars.add(new RacingCar(name));
        }
        return racingCars;
    }
}
