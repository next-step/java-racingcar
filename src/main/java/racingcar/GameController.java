package racingcar;

import java.util.List;

public class GameController {

    public static void main(String[] args) {
        RacingCarGame racingCarGame = createRacingCarGame();
        OutputView.printTitle();

        while (!racingCarGame.isEnd()) {
            List<Position> playResults = racingCarGame.play(new RandomMovingStrategy());
            OutputView.printPlayResults(playResults);
        }
    }

    private static RacingCarGame createRacingCarGame() {
        int carCount = InputView.getCarCount();
        int playCount = InputView.getPlayCount();
        return new RacingCarGame(carCount, playCount);
    }

}
