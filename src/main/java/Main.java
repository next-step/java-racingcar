import racing.domain.RacingGame;
import racing.domain.RandomMoveStrategy;
import racing.view.InputView;
import racing.view.RacingView;

public class Main {

    public static void main(String[] args) {
        InputView inputView = InputView.enterInput();

        RacingGame racingGame = new RacingGame(inputView.getNumberOfCar(), inputView.getNumberOfRound());

        RacingView racingView = new RacingView();
        racingView.print(racingGame.play(new RandomMoveStrategy()));
    }
}
