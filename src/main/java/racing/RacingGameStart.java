package racing;

import racing.domain.car.RacingCars;
import racing.domain.game.RacingGame;
import racing.domain.game.RacingGameResult;
import racing.view.InputView;
import racing.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class RacingGameStart {

    public static void main(String[] args) {
        String inputNames = InputView.inputCarNames();
        int times = InputView.inputTime();

        List<String> winnerList = new ArrayList<>();

        RacingCars racingCars = new RacingCars(inputNames);
        RacingGame racingGame = new RacingGame(racingCars);
        RacingGameResult racingGameResult = new RacingGameResult(racingCars, winnerList);

        ResultView.resultMessage();
        racingGameResult.resultRacing(times);
        ResultView.printWinner(racingGame);
    }
}
