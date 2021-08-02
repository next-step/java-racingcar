package race.controller;

import racing.controller.RacingGame;
import racing.model.Car;
import racing.model.Racing;
import racing.view.Output;

import java.util.List;

public class TestRacingGame extends RacingGame {

    private int playingCount = 0;

    public TestRacingGame(int gameCount) {
        super(gameCount);
    }

    public List<Car> gameStartTest(Racing racing) {
        List<Car> carList;
        do {
            carList = racing.game();
            playingCount++;
        } while (!endGame());
        return carList;
    }

    public int getPlayingCount() {
        return this.playingCount;
    }
}
