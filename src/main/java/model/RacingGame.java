package model;

import view.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RacingGame {
    private final List<Car> carList;

    public RacingGame(int numOfCars) {
        this(numOfCars, new RandomMove());
    }

    public RacingGame(int numOfCars, MoveStrategy moveStrategy) {
        this.carList = participate(numOfCars, moveStrategy);
    }

    public RacingGame(List<Car> cars) {
        this.carList = cars;
    }

    private List<Car> participate(int numOfCars, MoveStrategy moveStrategy) {
        List<Car> result = new ArrayList<>();
        for (int i = 1; i <= numOfCars; i++) {
            result.add(new Car(moveStrategy));
        }

        return result;
    }

    public ResultView run(int turn) {
        ResultView resultView = new ResultView();
        for (int t = 1; t <= turn; t++) {
            move();
            record(resultView);
        }

        return resultView;
    }

    public void move() {
        for (Car car : carList) {
            car.move();
        }
    }

    private void record(ResultView resultView) {
        for (Car car : carList) {
            resultView.record(car);
        }

        resultView.appendNewLine();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RacingGame that = (RacingGame) o;
        return Objects.equals(carList, that.carList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carList);
    }
}
