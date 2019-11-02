package step1.racing;

import java.util.List;

import step1.racing.data.GameCount;
import step1.racing.data.RacingCar;
import step1.racing.data.RacingCars;

public class RacingCarHandler {
    private final RacingCars racingCars;
    private final GameCount gameCount;

    public RacingCarHandler(List<RacingCar> racingCarList, int playTimes) {
        this.racingCars = new RacingCars(racingCarList);
        this.gameCount = new GameCount(playTimes);
    }

    public List<RacingCar> getWinners() {
        return racingCars.getWinners();
    }

    public void race(Moveable moveStrategy) {
        while (gameCount.isPlayable()) {
            doRace(moveStrategy);
        }
    }

    private void doRace(Moveable moveStrategy) {
        racingCars.race(moveStrategy);
    }

    public List<RacingCar> getRacingCars() {
        return racingCars.getRacingCars();
    }
}
