package racingcar.presentation;

import racingcar.domain.Car;

import java.util.List;

public class ResultView {

    private final String CAR_POSITION_PRINT_UNIT = "-";

    public void printResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(carPosition(car));
        }
        System.out.println();
    }

    private String carPosition(Car car) {
        return CAR_POSITION_PRINT_UNIT.repeat(car.position()+1);
    }
}
