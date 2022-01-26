package racingcar;

import racingcar.domain.RacingGame;
import racingcar.view.InputView;

public class Application {

    public static void main(String[] args) {
        String carNames = InputView.getCarNames();
        int tryNo = InputView.getRaceCount();
        RacingGame carRace = new RacingGame(carNames, tryNo);
        carRace.run();
    }
}
