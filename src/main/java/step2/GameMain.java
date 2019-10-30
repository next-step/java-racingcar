package step2;

import java.util.List;

public class GameMain {

    public static void main(String[] args) {

        InputView inputView = new InputView();
        int carNum = inputView.getCarNum();
        int trialNum = inputView.getTrialNum();

        RacingGame racingGame = new RacingGame(carNum, trialNum);
        List<Car> cars = racingGame.doGame();

        ResultView resultView = new ResultView();
        resultView.printGame(cars, trialNum);


    }
}
