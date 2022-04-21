package racing;

import racing.controller.RacingGame;
import racing.domain.GameCondition;
import racing.domain.RacingCar.Name;
import racing.view.InputView;
import racing.view.ResultView;

import java.util.List;

public class RacingGameApplication {

    public static void main(String[] args) {
        new RacingGameApplication().run(args);
    }

    public void run(String[] args) {
        String racingCarNames = InputView.inputRacingCarNames();
        int totalRounds = InputView.inputRounds();

        GameCondition gameCondition = new GameCondition(racingCarNames, totalRounds);
        RacingGame racingGame = new RacingGame(gameCondition);
        List<Name> winners = racingGame.gameStart();
        ResultView.printResult(winners);
    }
}
