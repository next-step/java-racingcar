package step1.racing;

import java.util.List;

import step1.racing.data.RacingCar;
import step1.racing.view.RaceSnapshot;

public class RacingGame {
    private final Moveable moveStrategy;
    private final RacingCars racingCars;

    public RacingGame(List<RacingCar> racingCarList, Moveable moveStrategy) {
        this.moveStrategy = moveStrategy;
        this.racingCars = new RacingCars(racingCarList);
    }

    public RaceSnapshot move() {
        race(moveStrategy);
        return new RaceSnapshot(racingCars);
    }

    public List<RacingCar> getWinners() {
        return racingCars.getWinners();
    }

    private void race(Moveable moveStrategy) {
        doRace(moveStrategy);
    }

    private void doRace(Moveable moveStrategy) {
        racingCars.race(moveStrategy);
    }


}
