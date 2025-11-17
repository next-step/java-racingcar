package carRacing;

public class Main {

    public static void main(String[] args) {
        RacingGame racingGame = new RacingGame(InputView.initCarInfo(), InputView.initTryCount());

        while (racingGame.isEnd()) {
            ResultView.printResult(racingGame.getRacingCars());
        }

        ResultView.printWinners(racingGame.findWinners());
    }
}
