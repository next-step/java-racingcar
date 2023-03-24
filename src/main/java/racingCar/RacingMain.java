package racingCar;

import racingCar.domain.RacingGame;
import racingCar.view.InputView;
import racingCar.view.ResultView;

public class RacingMain {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        String carNames = inputView.getCarNames();
        int tryNo = inputView.getTryNo();

        RacingGame racingGame = new RacingGame(carNames, tryNo);
        System.out.println("\n실행 결과");
        while (!racingGame.isEnd()) {
            racingGame.race(racingGame.getCars());
            resultView.printCars(racingGame.getCars());
        }
        resultView.printWinners(racingGame.getWinners());
    }
}
