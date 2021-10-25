package racingcar;

import racingcar.domains.Cars;
import racingcar.views.InputView;
import racingcar.views.ResultView;

import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        InputView inputView = new InputView();
        Map<String, String> racingInfoMap = inputView.getRacingInformation();

        RacingGame racingGame = new RacingGame(racingInfoMap);
        List<Cars> racingResult = racingGame.race();

        String winnerNames = racingGame.getWinners();

        ResultView resultView = new ResultView();
        resultView.printRacingResult(racingResult);
        resultView.printRacingWinner(winnerNames);
    }
}
