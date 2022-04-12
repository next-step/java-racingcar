package view;

import racingcar.Cars;

public class ResultView {
    private static final String MOVE_EXPRESSION = "-";

    public void printCarsMoveState(Cars cars) {
        cars.carsMoveState(MOVE_EXPRESSION)
                .forEach(System.out::println);
        System.out.println();
    }

}
