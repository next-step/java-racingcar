package step5.model;

import java.util.List;
import step5.view.CarDTO;

public class CarRacingGame {

    private final Cars cars;
    private int roundCount;

    public CarRacingGame(int roundCount, String[] carNames) {
        this.roundCount = roundCount;
        this.cars = new Cars(carNames);
    }

    public List<CarDTO> getCars() {
        return cars.getCars();
    }

    public List<CarDTO> getWinners() {
        return cars.getWinners().getCars();
    }

    public boolean hasMoreRounds() {
        return roundCount > 0;
    }

    public void moveCars() {
        roundCount--;
        cars.move();
    }

    //for test
    protected int getRoundCount() {
        return roundCount;
    }

}
