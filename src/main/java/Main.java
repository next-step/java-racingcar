import controller.RacingGame;
import view.InputView;
import view.ResultView;

public class Main {
    public static void main(String[] args) {
        String carNames = InputView.getParticipatedCarNames();
        int tryCount = InputView.getTryCount();

        RacingGame racingGame = new RacingGame(carNames);
        ResultView resultView = new ResultView();
        for (int i = 0; i < tryCount; i++) {
            racingGame.play();
            resultView.broadcast(racingGame.participatedCars());
            System.out.println();
        }
        resultView.printWinner(racingGame.getWinners());

    }

}
