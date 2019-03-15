package racinggame;

import racinggame.domain.RacingGame;
import racinggame.domain.RacingResult;
import racinggame.view.InputView;
import racinggame.view.ResultView;

import java.util.List;
import java.util.Scanner;

public class ConsoleRacingGameLauncher {

    private static InputView inputView = new InputView(new Scanner(System.in));
    private static ResultView resultView = new ResultView();

    public static void main(String[] args) {
        List<String> carNames = inputView.getCarNames();
        Integer numberOfTries = inputView.getNumberOfTries();

        RacingGame racingGame = new RacingGame(carNames, numberOfTries);

        resultView.showResultTitle();
        RacingResult result = new RacingResult(racingGame.getCars());
        for( int i = 0; i < numberOfTries; ++i ) {
            racingGame.proceed(result);
            resultView.showCarPositions(result);
        }
        resultView.showWinners(result);
    }
}