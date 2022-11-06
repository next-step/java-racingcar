package racinggame;

import racinggame.domain.Cars;

import java.util.List;

public class ResultView {
    private static final String TRACE_MARK = "-";

    public static void printResult(Cars cars) {
        System.out.println("실행 결과");

        printCars(cars);

        printWinners(cars);
    }

    private static void printWinners(final Cars cars) {
//        System.out.println(String.join(", ", winners) + "가 최종 우승했습니다.");
    }

    private static void printCars(Cars cars) {
//        for (RacingCar car : cars.getCars()) {
//            System.out.println(car.toView().toString());
//        }
    }

}
