package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.RacingResult;

public class ResultView {

    private ResultView() {
    }

    public static void print(RacingResult results) {
        for (int i = 0; i < results.size(); i++) {
            print(results.get(i));
        }

        String winners = String.join(",", results.getWinners());
        System.out.println(winners + "가 최종 우승했습니다.");
    }

    private static void print(Cars cars) {
        for (int i = 0; i < cars.size(); i++) {
            print(cars.get(i));
        }

        System.out.println();
    }

    private static void print(Car car) {
        System.out.print(String.format("%s:", car.getName()));

        for (int i = 0; i < car.getPosition(); i++) {
            System.out.print("-");
        }

        System.out.println();
    }
}
