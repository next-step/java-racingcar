package step1.racing;

import java.util.List;

import step1.racing.data.GameCount;
import step1.racing.data.RacingCar;

public class RacingGame {
    private final Moveable moveStrategy;
    private final RacingCars racingCars;
    private final GameCount gameCount;

    public RacingGame(List<RacingCar> racingCarList, Moveable moveStrategy, int playTimes) {
        this.moveStrategy = moveStrategy;
        this.racingCars = new RacingCars(racingCarList);
        this.gameCount = new GameCount(playTimes);
    }

    public void move() {
        race(moveStrategy);
    }

    public List<RacingCar> getWinners() {
        return racingCars.getWinners();
    }

    public List<RacingCar> getRacingCars() {
        return racingCars.getRacingCars();
    }

    private void race(Moveable moveStrategy) {
        while (gameCount.isPlayable()) {
            doRace(moveStrategy);
        }
    }

    private void doRace(Moveable moveStrategy) {
        racingCars.race(moveStrategy);
    }


}
