package racingcar.view;

import racingcar.vo.CarDto;
import racingcar.vo.CarsDto;

import java.util.stream.IntStream;

public class ResultView {
    private static final String MOVEMENT = "-";

    public ResultView() {
        System.out.println("실행 결과");
    }

    public void printAllCarsMovement(CarsDto cars) {
        IntStream.range(0, cars.getSize())
                .forEach(i -> printACarMovement(cars.getCarDto(i)));
        System.out.println();
    }

    private void printACarMovement(CarDto car) {
        System.out.print(car.getCarName().getName() + " : ");
        IntStream.range(0, car.getCarPosition().getPosition())
                .forEach(i -> System.out.print(MOVEMENT));
        System.out.println();
    }

    public void printWinners(String winners) {
        System.out.println(winners + "가 최종 우승했습니다.");
    }
}
