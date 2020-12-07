package racinggame;

import racinggame.domain.RacingCarGame;
import racinggame.view.InputView;
import racinggame.view.OutputView;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        RacingCarGame racingCarGame = new RacingCarGame(InputView.carNames(), InputView.gameCount());
        racingCarGame.gameStart();
        OutputView.print(new ArrayList<>(racingCarGame.getGameResults().values()));
        OutputView.printWinners(racingCarGame.pickLastWinners());
    }
}
