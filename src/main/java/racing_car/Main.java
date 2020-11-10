package racing_car;

import racing_car.view.InputView;
import racing_car.view.ResultView;


public class Main {

    public static void main(String[] args) {
        RacingSpec spec = InputView.enterInput();
        RacingRecord racingRecord = new RacingGame(spec).play();
        ResultView.drawRacingResult(racingRecord);
    }
}
