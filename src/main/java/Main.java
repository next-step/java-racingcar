import racing.domain.RacingGame;
import racing.domain.RacingResult;
import racing.domain.RandomMoveStrategy;
import racing.view.InputView;
import racing.view.RacingView;

public class Main {

    public static void main(String[] args) {
        InputView inputView = InputView.enterInput();

        RacingGame racingGame = new RacingGame(inputView.getCarNames(), inputView.getNumberOfRound());
        RacingResult racingResult = racingGame.play(new RandomMoveStrategy());

        RacingView racingView = new RacingView();
        racingView.print(racingResult);
    }
}
