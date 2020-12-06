package racinggame;

import racinggame.domain.RacingCarGame;
import racinggame.view.InputView;
import racinggame.view.OutputView;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        RacingCarGame racingCarGame = new RacingCarGame();
        racingCarGame.gameStart(InputView.carNames(), InputView.gameCount());
        OutputView.print(new ArrayList<>(racingCarGame.getGameResults().values()));
    }
}
