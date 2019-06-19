package racing.model;

import racing.io.OutputView;

import java.util.List;

public class RacingGame {

    private List<Car> cars;
    private int gameCount;


    private RacingGame(List<Car> cars, int gameCount) {
        this.cars = cars;
        this.gameCount = gameCount;
    }

    public static RacingGame of(List<Car> cars, int gameCount) {
        return new RacingGame(cars, gameCount);
    }


    public void run() {
        while (gameCount != 0) {
            movingCars();
            viewResult();
            gameCount--;
        }
    }

    private void viewResult() {
        OutputView.view(this.cars);
    }

    private void movingCars() {
        this.cars.forEach(this::moveWhenHigher4);
    }

    private void moveWhenHigher4(Car car) {
        if (RandomNumberCreator.getZeroToNine() >= 4) car.move();
    }


}
