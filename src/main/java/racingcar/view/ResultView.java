package racingcar.view;

import racingcar.model.Car;
import racingcar.model.Cars;

public class ResultView {
    public static void printCars(Cars cars) {
        for (Car car : cars.getCars()) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    public static void printWinners(Cars cars) {
        for (Car car : cars.getCars()) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println(String.join(",", cars.getWinners()) + "가 최종 우승했습니다.");
    }
}
