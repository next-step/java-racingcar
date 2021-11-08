package racingcargame.ui;

import racingcargame.domain.RacingCar;

public class ResultView extends AbstractView {
    private final String resultMessage = "실행 결과";

    public void printResultMessage() {
        print(resultMessage);
    }

    public void printCurrentStateOfRacingCar(RacingCar racingCar) {
        print(racingCar.getCurrentState());
    }
}
