package step3.racinggame.core;

import java.util.List;
import step3.racinggame.core.gasstation.GasStation;

public class RacingGame {

    private final List<Car> cars;

    private final GasStation gasStation;

    public RacingGame(List<Car> cars, GasStation gasStation) {
        this.cars = cars;
        this.gasStation = gasStation;
    }

    public ScoreBoard play(int numOfGame) {
        ScoreBoard scoreBoard = new ScoreBoard(numOfGame, cars.size());

        for (int i = 0; i < numOfGame; i++) {
            playRound(i, scoreBoard);
        }

        return scoreBoard;
    }

    private void playRound(int round, ScoreBoard scoreBoard) {
        for (int j = 0; j < cars.size(); j++) {
            Car car = cars.get(j);
            car.move(gasStation.sellFuel());

            scoreBoard.setDistance(car.getDistance(), round + 1, j + 1);
        }
    }
}
