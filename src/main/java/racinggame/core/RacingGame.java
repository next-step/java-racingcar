package racinggame.core;

import java.util.List;
import racinggame.core.gasstation.GasStation;
import racinggame.core.scoreboard.ScoreBoard;

public class RacingGame {

    private final List<Car> cars;

    private final GasStation gasStation;

    public RacingGame(List<Car> cars, GasStation gasStation) {
        this.cars = cars;
        this.gasStation = gasStation;
    }

    public ScoreBoard play(int round) {
        ScoreBoard scoreBoard = new ScoreBoard();

        for (int i = 0; i < round; i++) {
            playRound(scoreBoard);
        }

        return scoreBoard;
    }

    private void playRound(ScoreBoard scoreBoard) {
        for (int j = 0; j < cars.size(); j++) {
            Car car = cars.get(j);
            car.move(gasStation.sellFuel());
        }
        scoreBoard.recordScore(cars);
    }
}
