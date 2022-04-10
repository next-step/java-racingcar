package view;

import racingcar.Cars;

public class ResultView {
    public void printCarsMoveState(Cars cars) {
        cars.getInstance()
                .forEach(car -> System.out.println(car.moveCountExpression()));
        System.out.println();
    }
}
