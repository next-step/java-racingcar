package step3;

import step3.view.InputView;
import step3.view.ResultView;

public class RacingApp {
    static int carCounts = 0, raceTimes = 0;
    static final int MOVE_BOUNDARY = 4;
    public static void main(String[] args) {

        carCounts = InputView.inputCountCar();
        raceTimes = InputView.inputRaceTimes();

        ResultView.startRace(carCounts,raceTimes);
    }



}
