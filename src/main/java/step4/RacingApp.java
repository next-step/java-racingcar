package step4;

import step4.action.Race;
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

        Race race = Race.of(carNames);

        for(int i=0; i<raceTimes; i++){
            race.doRace();
            ResultView.printCars(race.getCars());
            System.out.println();
        }
        ResultView.printResult(race.getWinner());
    }
}
