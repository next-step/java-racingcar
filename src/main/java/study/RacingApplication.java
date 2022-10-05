package study;

import static study.RacingGame.*;

public class RacingApplication {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        Cars cars = carTryMove(new Cars(makeCarList(inputView.carCount())), inputView.tryCount());
        resultView.racingResult(cars);
    }
}
