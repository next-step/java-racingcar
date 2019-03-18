package racing;

import racing.domain.RacingGame;
import racing.domain.WinnerCar;
import racing.view.InputView;
import racing.view.ResultView;

import java.util.Arrays;

public class ConsoleApplication {
    private static final String SEPARATOR = ",";

    public static void main(String[] args) {
        String carNames = InputView.inputCarName();
        int tryNo = InputView.inputTryCount();

        RacingGame racingGame = new RacingGame(Arrays.asList(carNames.split(SEPARATOR)), tryNo);
        while(!racingGame.isEnd()) {
            ResultView.printResult(racingGame.playRacing());
        }
        ResultView.printWinner(new WinnerCar().getWinners(racingGame.playRacing()));
    }
}
