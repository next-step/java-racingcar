import domain.RacingGame;
import domain.RacingGameResult;
import view.InputView;
import view.ResultView;

public class Main {
    public static void main(String[] args) {
        Integer carNumber = InputView.inputCarNumber();
        Integer roundNumber = InputView.inputRoundNumber();

        RacingGame racingGame = RacingGame.create(carNumber, roundNumber);
        RacingGameResult racingGameResult = racingGame.start();
        ResultView.printGameResult(racingGameResult);
    }
}