package racingcar.view;

import racingcar.Car;

import java.util.List;

public class ResultView {

    public static void printRoundResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.toString() + " : " + car.locationMark());
        }
        System.out.println();
    }

    public static void printGameResult(List<Car> cars) {
        System.out.println(cars.toString() + "가 최종 우승했습니다.");
    }
}
