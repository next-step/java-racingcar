package racinggame.core;

import racinggame.core.car.Car;
import racinggame.core.car.Cars;
import racinggame.core.gasstation.GasStation;
import racinggame.core.scoreboard.ScoreBoard;

public class RacingGame {

    private final Cars cars; //일급 컬렉션 적용 대상 -> Cars

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
