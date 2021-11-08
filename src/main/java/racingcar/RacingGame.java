package racingcar;

import racingcar.collection.RaceHistories;
import racingcar.collection.RacingCarList;
import racingcar.collection.RaceResult;
import racingcar.model.RacingGameRequest;
import racingcar.strategy.MoveStrategy;
import racingcar.strategy.RandomMoveStrategy;

public class RacingGame {
    private final RacingCarList carList = new RacingCarList();
    private final int countOfTry;

    public RacingGame(RacingGameRequest request) {
        this.countOfTry = request.getCountOfTry();

        MoveStrategy moveStrategy = new RandomMoveStrategy();
        for (int i = 0; i < request.getCountOfCar(); i++) {
            carList.participate(new Car(moveStrategy));
        }
    }

    public RaceHistories playRace() {
        RaceHistories histories = new RaceHistories();
        for (int i = 0; i < countOfTry; i++) {
            RaceResult result = race();
            histories.addRaceResult(result);
        }
        return histories;
    }

    private RaceResult race() {
        RaceResult raceResult = new RaceResult();
        carList.getCars().forEach(car -> {
            car.move();
            raceResult.addResult(car);
        });

        return raceResult;
    }
}
