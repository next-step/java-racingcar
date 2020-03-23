import domain.RacingGame;
import domain.RacingGameResult;
import view.InputView;
import view.ResultView;

public class Main {
    public static void main(String[] args) {
        String[] carNames = InputView.inputCarNames();
        Integer roundNumber = InputView.inputRoundNumber();

        RacingGame racingGame = RacingGame.create(carNames, roundNumber);
        RacingGameResult racingGameResult = racingGame.start();
        ResultView.printGameResult(racingGameResult);
    }
}