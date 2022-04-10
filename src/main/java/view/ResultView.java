package view;

import racingcar.Car;
import racingcar.Cars;

import java.util.stream.IntStream;

public class ResultView {
    private static final int RANGE_LIST_START_NUMBER = 0;
    private static final String MOVE_EXPRESSION = "-";

    public void printCarsMoveState(Cars cars) {
        cars.getInstance()
                .forEach(this::print);
        System.out.println();
    }

    private void print(Car car) {
        IntStream.range(RANGE_LIST_START_NUMBER, car.getMoveCount())
                .mapToObj(count -> MOVE_EXPRESSION)
                .forEach(System.out::print);
        System.out.println();
    }
}
