package racinggame;

import racinggame.domain.RacingCarGame;
import racinggame.view.InputView;
import racinggame.view.OutputView;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        int carCount = InputView.carCount();
        int gameCount = InputView.gameCount();
        RacingCarGame racingCarGame = new RacingCarGame(carCount, gameCount);
        racingCarGame.gameStart();
        OutputView.print(new ArrayList<>(racingCarGame.getGameResults().values()));
    }
}
