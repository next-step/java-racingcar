package racing.model;

import java.util.List;

public class Racing {
    private static final int END_GAME_COUNT = 0;

    private Cars cars = new Cars();
    private int gameCount = 0;

    public Racing(String[] carNames, int gameCount) {
        this.cars.prepareCars(carNames);
        this.gameCount = gameCount;
    }

    public List<Car> winnerCarList() {
        return cars.findWinners();
    }

    public List<Car> game() {
        return cars.carsMove();
    }

    public Boolean endGame() {
        if (this.gameCount > END_GAME_COUNT) {
            this.gameCount--;
        }
        return gameCount == END_GAME_COUNT;
    }
}
