package racinggame.domain;

import racinggame.domain.car.Car;
import racinggame.domain.car.Cars;
import racinggame.domain.gasstation.GasStation;
import racinggame.domain.scoreboard.ScoreBoard;

public class RacingGame {

    private final Cars cars;

    private final GasStation gasStation;

    public RacingGame(Cars cars, GasStation gasStation) {
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
        for (int j = 0; j < cars.getSize(); j++) {
            Car car = cars.getCar(j);
            car.move(gasStation.sellFuel());
        }
        scoreBoard.recordScore(cars);
    }
}
