package racingcar;

import racingcar.collection.*;
import racingcar.model.RacingGameRequest;
import racingcar.strategy.MoveStrategy;

import java.util.List;

public class RacingGame {
    private final int countOfTry;
    private final RacingCarList carList = new RacingCarList();

    public RacingGame(RacingGameRequest request, MoveStrategy moveStrategy) {
        this.countOfTry = request.getCountOfTry();

        for (String carName: request.getCarNames()) {
            carList.participate(new Car(new CarName(carName), moveStrategy));
        }
    }

    public RaceResult playRace() {
        RaceResult raceResult = new RaceResult();
        for (int i = 0; i < countOfTry; i++) {
            LapResult result = race();
            raceResult.addRaceResult(result);
        }

        for (Winner winner: getWinnerList()) {
            raceResult.addWinner(winner);
        }
        return raceResult;
    }

    private List<Winner> getWinnerList() {
        int maxPosition = this.carList.getMaxPosition();

        return this.carList.getWinners(maxPosition);
    }

    private LapResult race() {
        LapResult lapResult = new LapResult();
        carList.moveAllAndGetMoveResultList().forEach(lapResult::addResult);

        return lapResult;
    }
}
