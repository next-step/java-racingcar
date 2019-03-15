package racinggame;

import racinggame.domain.RacingResult;
import racinggame.view.InputView;
import racinggame.view.ResultView;

import java.util.List;
import java.util.Scanner;

public class RacingGameLauncher {

    public static void main(String[] args) {
        InputView inputView = new InputView(new Scanner(System.in));
        List<String> carNames = inputView.getCarNames();
        Integer numberOfTries = inputView.getNumberOfTries();

        RacingGame racingGame = new RacingGame(new Configuration(carNames, numberOfTries));

        ResultView resultView = new ResultView();
        resultView.showResultTitle();

        RacingResult result = new RacingResult(racingGame.createCars());
        for( int i = 0; i < numberOfTries; ++i ) {
            racingGame.proceed(result);
            resultView.showCarPositions(result);
        }
        resultView.showWinners(result);
    }
}