package racingCar;

import racingCar.domain.GameResult;
import racingCar.domain.RacingGame;
import racingCar.view.InputView;
import racingCar.view.ResultView;

import static racingCar.Car.getNamesFromList;
import static racingCar.domain.GameResult.getWinnerList;

public class ConsoleMain {

    public static void main(String[] args) {
        String carNames = InputView.getCarNames();
        int tryNo = InputView.getTryNo();

        RacingGame racingGame = new RacingGame(carNames);
        GameResult result = new GameResult();

        for(int i = 0; i < tryNo; i++) {
            result = racingGame.move();
            ResultView.print(result);
        }
        ResultView.printWinner(result);
    }

}
