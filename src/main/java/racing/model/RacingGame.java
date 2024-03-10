package racing.model;

import racing.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private List<Car> cars = new ArrayList<>();

    public RacingGame(int numberOfCars) {
        this(numberOfCars, new RandomMovement());
    }

    public RacingGame(int numberOfCars, CarMovementStrategy carMovementStrategy) {
        this.cars = joinCars(numberOfCars, carMovementStrategy);
    }

    private List<Car> joinCars(int numberOfCars, CarMovementStrategy carMovementStrategy) {
        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < numberOfCars; i++) {
            cars.add(new Car(carMovementStrategy));
        }

        return cars;
    }

    public ResultView getResult(int numberOfAttempts) {
        ResultView resultView = new ResultView();

        for (int i = 0; i < numberOfAttempts; i++) {
            move();
            record(resultView);
        }

        return resultView;
    }

    private void move() {
        for (Car car : cars) {
            car.move();
        }
    }

    private void record(ResultView resultView) {
        for (Car car : cars) {
            resultView.record(car);
        }

        resultView.appendNewLine();
    }

}
