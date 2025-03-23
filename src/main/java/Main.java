import controller.RacingGame;
import view.InputView;
import view.ResultView;

public class Main {
    public static void main(String[] args) {
        String carNames = InputView.getParticipatedCarNames();
        int tryCount = InputView.getTryCount();

        RacingGame racingGame = new RacingGame(carNames);
        racingGame.play(tryCount);
        ResultView.printWinner(racingGame.getWinners());
    }

}
