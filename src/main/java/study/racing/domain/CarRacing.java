package study.racing.domain;

import study.racing.view.InputView;
import study.racing.view.ResultView;

public class CarRacing {

    private RacingMoveStrategy racingMoveStrategy;

    public CarRacing(RacingMoveStrategy racingMoveStrategy) {
        this.racingMoveStrategy = racingMoveStrategy;
    }

    public RacingRecords start(String[] carNames, int tryCnt){
        Cars cars = new Cars(carNames);
        return racing(tryCnt, cars);
    }

    private RacingRecords racing(int tryCnt, Cars cars) {
        RacingGameRounds racingGameRounds = new RacingGameRounds(tryCnt);

        while (!racingGameRounds.isEnd()){
            cars.move(racingMoveStrategy);
            racingGameRounds.roundClose();
            racingGameRounds.recording(cars);
        }
        return racingGameRounds.getRecordingResult();
    }
}
