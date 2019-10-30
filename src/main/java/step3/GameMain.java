package step3;

import java.util.List;

public class GameMain {

    public static void main(String[] args) {

        InputView inputView = new InputView();
        String carNames = inputView.getCarNames();
        int trialNum = inputView.getTrialNum();

        RacingGame racingGame = new RacingGame(carNames, trialNum);
        List<Car> cars = racingGame.doGame();

        ResultView resultView = new ResultView();
        resultView.printGame(cars, trialNum);


    }
}
