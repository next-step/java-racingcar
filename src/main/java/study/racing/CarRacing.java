package study.racing;

import study.racing.view.InputView;
import study.racing.view.ResultView;

public class CarRacing {

    private RacingMoveStrategy racingMoveStrategy;

    public CarRacing(RacingMoveStrategy racingMoveStrategy) {
        this.racingMoveStrategy = racingMoveStrategy;
    }

    public RacingRecords start(int carCnt, int tryCnt){
        Cars cars = new Cars(carCnt);

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

    public static void main(String args[]){

        int carCnt = InputView.getCarCount();
        int tryCnt = InputView.getTryCount();

        InputView.validateCarCount(carCnt);
        InputView.validateTryCount(tryCnt);

        ResultView resultView = new ResultView();
        resultView.showResultHead();

        CarRacing carRacing = new CarRacing(new RandomMoveStrategy());
        RacingRecords racingResults = carRacing.start(carCnt, tryCnt);
        resultView.showResult(racingResults);
    }
}
