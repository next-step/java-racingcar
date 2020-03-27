package domain;

import java.util.List;

public class RacingGame {

    private Cars cars;

    public RacingGame(Cars cars) {
        this.cars = cars;
    }

    public void playGame(List<Integer> randomNumbers) {
        cars.move(randomNumbers);
    }

    public List<String> getWinners() {
        return cars.getWinner();
    }
}
