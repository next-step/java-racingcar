package step3;

import step3.view.InputView;
import step3.view.ResultView;

public class RacingApp {
//    static int carCounts = 0, raceTimes = 0;
    public static final int MOVE_BOUNDARY = 4;
    public static void main(String[] args) {
        startApp();
    }

    private static void startApp() {
        int carCounts = InputView.inputCountCar();
        int raceTimes = InputView.inputRaceTimes();
        ResultView.startRace(carCounts,raceTimes);
    }

//    private static void input() {
//        carCounts = InputView.inputCountCar();
//        raceTimes = InputView.inputRaceTimes();
//    }


}
