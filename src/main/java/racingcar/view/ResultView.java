package racingcar.view;

import racingcar.Car;
import racingcar.Cars;

import java.util.stream.IntStream;

public class ResultView {
    private static final String MOVEMENT = "-";

    public ResultView() {
        System.out.println("실행 결과");
    }

    public void printAllCarsMovement(Cars cars) {
        IntStream.range(0, cars.getSize())
                .forEach(i -> printACarMovement(cars.getCar(i)));
        System.out.println();
    }

    private void printACarMovement(Car car) {
        IntStream.range(0, car.getMovement())
                .forEach(i -> System.out.print(MOVEMENT));
        System.out.println();
    }
}
