package step3.racinggame.core;

import java.util.List;

public class RacingGame {

    private final List<Car> cars;

    private final FuelTank fuelTank;

    public RacingGame(List<Car> cars, FuelTank fuelTank) {
        this.cars = cars;
        this.fuelTank = fuelTank;
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
            car.move(fuelTank.takeFuel());

            scoreBoard.setDistance(car.getDistance(), round + 1, j + 1);
        }
    }
}
