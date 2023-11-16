package step5.presentation;

import step5.domain.Car;
import step5.domain.Cars;

import java.util.List;
import java.util.stream.IntStream;

public class RacingResultView {

    private static final String VIEW_OF_CAR = "-";

    public void printCars(Cars cars) {
        System.out.println("실행 결과");

        IntStream.range(0, cars.countCars())
            .forEach(carNo ->{
                Car car = cars.findCarBy(carNo);
                System.out.println(car.carName() + " : " + VIEW_OF_CAR.repeat(car.position()));
            });

        System.out.println();
    }

    public void printWinners(List<String> winners) {
        System.out.println(winners + "가 최종 우승했습니다.");
    }
}
