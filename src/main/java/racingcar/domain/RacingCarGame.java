package racingcar.domain;

public class RacingCarGame {

    private final Cars cars;
    private final int moveCount;

    public RacingCarGame(String carNames, int moveCount) {
        this.cars = Cars.createCars(carNames);
        this.moveCount = moveCount;
    }

    public Cars getCars() {
        return cars;
    }

    public void execute(Strategy strategy) {
        GameResult gameResult = new GameResult(cars);

        for (int i = 0; i < moveCount; i++) {
            cars.carRacing(strategy);
            gameResult.displayResult();
        }

        Cars winners = cars.getWinners();
        gameResult.displayWinner(winners);
    }
}

