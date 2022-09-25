package racingcar;

import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class GameController {

    public static final MovingStrategy MOVING_STRATEGY = new RandomMovingStrategy();

    public static void main(String[] args) {
        RacingCarGame racingCarGame = createRacingCarGame();
        OutputView.printTitle();

        while (!racingCarGame.isEnd()) {
            List<Position> playResults = racingCarGame.play(MOVING_STRATEGY);
            OutputView.printPlayResults(playResults);
        }
    }

    private static RacingCarGame createRacingCarGame() {
        int carCount = InputView.getCarCount();
        int playCount = InputView.getPlayCount();
        return new RacingCarGame(carCount, playCount);
    }

}
