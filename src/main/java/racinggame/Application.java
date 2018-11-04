package racinggame;

public class Application {

    public static void main(String[] args) {

        int carCount = InputView.inputCarCount();
        int raceTime = InputView.inputRaceTime();

        RacingGame racingGame = new RacingGame(carCount, raceTime);

        while(!racingGame.isRaceEnd()) {
            int[] racingResult = racingGame.raceOneTime();
            ResultView.resultRacing(racingResult);
        }


    }
}
