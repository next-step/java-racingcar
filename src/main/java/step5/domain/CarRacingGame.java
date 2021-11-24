package step5.domain;

import step5.domain.cargameStrategy.CarRacingGameStrategy;
import step5.domain.dto.CarData;

import java.util.List;

public class CarRacingGame {

    private final CarRacingGameStrategy carRacingGameStrategy;
    private final Cars cars;
    private final int totalRound;
    private final GameHistory gameHistory;

    public CarRacingGame(CarRacingGameStrategy carRacingGameStrategy, Cars cars, int totalRound) {
        this.cars = cars;
        this.carRacingGameStrategy = carRacingGameStrategy;
        this.totalRound = totalRound;
        this.gameHistory = new GameHistory();
    }

    public void play() {
        for (int i = 0; i < totalRound; i++) {
            GameRound gameRound = new GameRound();
            gameRound.play(cars, carRacingGameStrategy);
            gameHistory.add(gameRound);
        }
    }

    public List<String> winners() {
        GameRound finalRound = gameHistory.finalRound();
        return finalRound.winners();
    }

    public GameHistory getGameHistory() {
        return gameHistory;
    }
}
