package study.racing;

import study.racing.domain.CarRacing;
import study.racing.domain.RacingRecords;
import study.racing.domain.RandomMoveStrategy;
import study.racing.view.InputView;
import study.racing.view.ResultView;

public class CarRacingMain {

    public static void main(String args[]){
        String[] carNames = InputView.getCarsName();
        int tryCnt = InputView.getTryCount();

        CarRacing carRacing = new CarRacing(new RandomMoveStrategy());
        RacingRecords racingResults = carRacing.start(carNames, tryCnt);

        ResultView.showResultHead();
        ResultView.showResult(racingResults);
    }
}
