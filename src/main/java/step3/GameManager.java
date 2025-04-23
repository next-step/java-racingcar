package step3;

import step3.dto.RaceRoundResult;

import java.util.List;

public class GameManager {

    public void start() {
        int carCount = InputView.inputCarCount();
        int raceCount = InputView.inputRaceCount();

        Game game = new Game(carCount, raceCount);
        List<RaceRoundResult> response = game.start();

        OutputView.draw(response);
    }
}
