package step03;

import java.util.List;

public class RacingEventManager {

    private int tryCount = 0;
    private String carNames;
    private RacingCarFactory racingCarFactory;

    public RacingEventManager(String carNames, int tryCount) {
        racingCarFactory = new RacingCarFactory(carNames);
        this.carNames = carNames;
        this.tryCount = tryCount;
    }

    public void startRandomRacing() {
        startRacing(new RandomMoveStrategy());
    }

    private void startRacing(MoveStrategy moveStrategy) {
        racing(moveStrategy, tryCount);
    }

    public void racing(MoveStrategy moveStrategy, int tryCount) {
        for (int i = 0; i < tryCount; i++) {
            racingCarFactory.moveCars(moveStrategy);
        }
    }

    public List<RacingCar> getRacingResult() {
        return racingCarFactory.getRacingCars();
    }
}
