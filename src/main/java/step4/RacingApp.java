package step4;

import step4.view.InputView;
import step4.view.ResultView;

public class RacingApp {

    public static final int MOVE_BOUNDARY = 4;

    public static void main(String[] args) {
        startApp();
    }

    private static void startApp() {
        String[] carNames = InputView.inputCountCar();
        int raceTimes = InputView.inputRaceTimes();
        ResultView.startRaceStep4(carNames,raceTimes);
    }
}
