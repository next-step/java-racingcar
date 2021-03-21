package step03;

import java.util.List;

public class RacingEventManager {

    private int tryCount = 0;
    private String carNames;
    private RacingCarFactory racingCarFactory;

    public RacingEventManager(String carNames, int tryCount) {
        this.carNames = carNames;
        this.tryCount = tryCount;
    }

    public void startRandomRacing() {
        startRacing(new RandomMoveStrategy());
    }

    private void startRacing(MoveStrategy moveStrategy) {
        racingCarFactory = new RacingCarFactory(carNames);
        racingCarFactory.racing(moveStrategy, tryCount);
    }

    public List<RacingCar> getRacingResult() {
        return racingCarFactory.getRacingCars();
    }
}
