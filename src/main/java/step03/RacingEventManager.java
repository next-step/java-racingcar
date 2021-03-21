package step03;

import java.util.List;

public class RacingEventManager {

    private RacingCarFactory racingCarFactory;
    private RacingCarRound racingCarRound;

    public RacingEventManager(String carNames, int tryCount) {
        racingCarFactory = new RacingCarFactory(carNames);
        racingCarRound = new RacingCarRound(tryCount);
    }

    public void startRandomRacing() {
        startRacing(new RandomMoveStrategy());
    }

    private void startRacing(MoveStrategy moveStrategy) {
        while (!racingCarRound.isFinishRound()) {
            racingCarFactory.moveCars(moveStrategy);
            racingCarRound.showRacingRoundResult(racingCarFactory.getRacingCars());
        }
    }

}
