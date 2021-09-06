package racingcar;

import racingcar.domain.RacingGame;
import racingcar.domain.RacingResults;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.List;

public class RacingCarMain {
    public static void main(String[] args) {

        String carsName = InputView.inputCarName();
        String[] cars = carsName.split(",");
        int attempt = InputView.inputAttempt();

        List<RacingResults> result = RacingGame.startRace(attempt, cars);
        ResultView.showRacing(result);


    }

}
