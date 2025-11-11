package carRacing;

public class Main {

    public static void main(String[] args) {
        String nameStr = InputView.initCarInfo();
        RacingGame racingGame = new RacingGame(nameStr.split(","));

        int tryCount = InputView.initTryCount();
        for (int i = 0; i < tryCount; i++) {
            racingGame.playGame();
            ResultView.printResult(racingGame.getRacingCars());
        }
        ResultView.printWinner(racingGame);
    }
}
