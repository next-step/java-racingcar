package racingCar;

import racingCar.View.InputView;
import racingCar.View.ResultView;



public class RacingCarMain {


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
