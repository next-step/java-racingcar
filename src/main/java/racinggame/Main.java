package racinggame;

import racinggame.domain.RacingCarGame;
import racinggame.view.InputView;
import racinggame.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> carNames = InputView.carNames();
        int gameCount = InputView.gameCount();
        RacingCarGame racingCarGame = new RacingCarGame(carNames, gameCount);
        racingCarGame.gameStart();
        OutputView.print(new ArrayList<>(racingCarGame.getGameResults().values()));
    }
}
