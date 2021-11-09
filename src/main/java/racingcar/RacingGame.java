package racingcar;

import racingcar.collection.*;
import racingcar.model.RacingGameRequest;
import racingcar.strategy.MoveStrategy;

import java.util.List;

public class RacingGame {
    private final int countOfTry;
    private final RacingCarList carList = new RacingCarList();
    private final MoveStrategy moveStrategy;

    public RacingGame(RacingGameRequest request, MoveStrategy moveStrategy) {
        this.countOfTry = request.getCountOfTry();
        this.moveStrategy = moveStrategy;

        request.getCarNames()
                .forEach(carName ->
                        carList.participate(new Car(new CarName(carName), this.moveStrategy)));
    }

    public RaceResult playRace() {
        RaceResult raceResult = new RaceResult();
        for (int i = 0; i < countOfTry; i++) {
            LapResult result = race();
            raceResult.addRaceResult(result);
        }

        getWinnerList().forEach(raceResult::addWinner);
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
