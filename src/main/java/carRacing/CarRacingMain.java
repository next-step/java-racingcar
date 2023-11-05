package carRacing;

import static carRacing.InputView.*;

public class CarRacingMain {
    public static void main(String[] args) {

        int carCount = readCarCount();
        int raceCount = readRaceCount();

        ResultView.resultTitle();
        startGame(carCount, raceCount);

    }

    private static void startGame(int carCount, int raceCount){
        RacingProcess racingProcess = new RacingProcess(carCount);

        racingProcess.ready();
        for (int i = 0; i < raceCount; i++) {
            racingProcess.round();
            ResultView.printRoundResult(racingProcess.showCarList());
        }
    }
}
