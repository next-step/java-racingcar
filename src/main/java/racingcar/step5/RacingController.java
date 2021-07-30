package racingcar.step5;


import racingcar.step5.domain.Car;
import racingcar.step5.domain.Race;
import racingcar.step5.domain.Validation;
import racingcar.step5.domain.Winner;
import racingcar.step5.view.InputView;
import racingcar.step5.view.ResultView;

import java.util.List;

public class RacingController {
    public static void main(String[] args) {
        String str =InputView.InputCarNames();
        Validation.checkForNull(str);
        int tryCount = InputView.InputTryCount();
        Validation.checkValidTryCount(tryCount);

        List<Car> cars = Car.createCars(str.split(","));

        ResultView.printResultMessage();
        for (int i = 0; i < tryCount; i++) {
            Race.startRaceGame(cars);
            ResultView.showGameResult(cars);
        }
        Winner winner = new Winner(cars);
        List<String> winnerList = winner.getWinnerList();
        ResultView.printWinnerNames(winnerList);

    }
}
