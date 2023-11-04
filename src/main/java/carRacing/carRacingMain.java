package carRacing;

import static carRacing.InputView.*;

public class carRacingMain {
    public static void main(String[] args) {

        int carCount = readCarCount();
        int raceCount = readRaceCount();

        CarRacingGame carRacingGame = new CarRacingGame(carCount, raceCount);

        ResultView.resultTitle();
        carRacingGame.startGame();


    }
}
