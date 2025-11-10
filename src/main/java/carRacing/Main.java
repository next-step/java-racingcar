package carRacing;

public class Main {

    public static void main(String[] args) {
        int carCount = InputView.initCarCount();
        RacingGame racingGame = new RacingGame();
        racingGame.initRacingCars(carCount);

        int tryCount = InputView.initTryCount();
        for (int i = 0; i < tryCount; i++) {
            racingGame.playGame();
            ResultView.printResult(racingGame.getRacingCars());
        }
    }
}
