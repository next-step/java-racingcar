package racingcar.step4;

import java.util.Collections;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        String strLiterals = InputView.InputCarNames();
        Validation.checkForNull(strLiterals);
        int tryCount = InputView.InputTryCount();
        Validation.checkValidTryCount(tryCount);

        List<Car> cars = Car.createCars(strLiterals.split(","));

        ResultView.printResultMessage();
        for (int i = 0; i < tryCount; i++) {
            Race.startRaceGame(cars);
            ResultView.showGameResult(cars);
        }
    }
}
