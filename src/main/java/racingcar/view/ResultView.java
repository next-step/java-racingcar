package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Cars;

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
        System.out.print(car.getCarName().getName() + " : ");
        IntStream.range(0, car.getCarPosition().getPosition())
                .forEach(i -> System.out.print(MOVEMENT));
        System.out.println();
    }

    public void printWinners(Cars cars) {
        System.out.println(cars.getWinners() +"가 최종 우승했습니다.");
    }
}
