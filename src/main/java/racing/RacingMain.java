package racing;

import racing.domain.RacingGame;
import racing.view.InputVeiw;
import racing.view.ResultView;

public class RacingMain {
    static InputVeiw inputVeiw = new InputVeiw();
    static ResultView resultView = new ResultView();


    public static void main(String[] args) {
        String carNames = inputVeiw.getCarNames();
        int tryNo = inputVeiw.getTryNo();

        RacingGame racingGame = new RacingGame(carNames, tryNo);
        while (!racingGame.isEnd()) {
            racingGame.race();
            resultView.printCars(racingGame.getCars());
        }
        resultView.printWinners(racingGame.getWinners());
    }
}
