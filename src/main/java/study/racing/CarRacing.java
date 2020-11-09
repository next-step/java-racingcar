package study.racing;

import study.calculator.CustomErrorMessage;
import study.racing.view.InputView;
import study.racing.view.ResultView;

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CarRacing {

    public RacingRecords start(int carCnt, int tryCnt){
        Cars cars = new Cars(carCnt);

        return racing(tryCnt, cars);
    }

    private RacingRecords racing(int tryCnt, Cars cars) {
        RacingGameRounds racingGameRounds = new RacingGameRounds(tryCnt);

        while (!racingGameRounds.isEnd()){
            cars.move();
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

        CarRacing carRacing = new CarRacing();
        RacingRecords racingResults = carRacing.start(carCnt, tryCnt);
        resultView.showResult(racingResults);
    }
}
