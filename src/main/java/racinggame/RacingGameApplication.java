package racinggame;

import racinggame.domain.RacingCar;
import racinggame.view.InputView;
import racinggame.view.ResultView;

import java.util.List;

public class RacingGameApplication {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        String inputNames = inputView.inputUserCarName();
        String[] names = inputNames.split(",");
        int tryCount = inputView.inputUserTryCount();

        RacingCar racingCar = RacingCar.of(List.of(names));

        resultView.printResultMessage();
        for (int i = 0; i < tryCount; i++) {
            resultView.printStatus(racingCar.racing());
        }
        resultView.printWinner(racingCar.getWinners());
    }
}
