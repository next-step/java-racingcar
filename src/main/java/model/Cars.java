package model;

import view.ResultView;

import java.util.List;

public class Cars {
    public static final String NOT_ENOUGH_CAR = "차량의 댓수가 부족합니다.";

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        if (cars == null || cars.isEmpty()) {
            throw new RuntimeException(NOT_ENOUGH_CAR);
        }

        this.cars = cars;
    }

    public void moveCars() {
        for (Car car : cars) {
            car.move(new RandomMoveRule());
        }
    }

    public void printCarsPosition() {
        ResultView resultView = ResultView.getInstance();

        for (Car car : this.cars) {
            resultView.printPosition(car.getPosition());
        }

        resultView.printLineBreak();
    }
}
