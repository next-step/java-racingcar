package race.view;

import race.MoveResult;
import race.RaceResult;

public class ResultView {
    private final RaceResult raceResult;

    public ResultView(RaceResult raceResult) {
        this.raceResult = raceResult;
    }

    public void showResult() {
        System.out.println("실행 결과");
        for (int i = 0; i < raceResult.getLaps(); i++) {
            showResultLap(i);
            System.out.println();
        }
    }

    private void showResultLap(int lap) {
        for (int i = 0; i < raceResult.getNumOfCars(); i++) {
            showResultCarAtLap(i, lap);
            System.out.println();
        }
    }

    private void showResultCarAtLap(int carNo, int lap) {
        for (int i = 0; i <= lap; i++) {
            MoveResult moveResult = raceResult.getMoveResultOfCarAtLap(carNo, i);
            System.out.print(moveResult == MoveResult.MOVED ? "-" : "");
        }
    }
}
