package racingcar.view;

import racingcar.model.Car;
import racingcar.model.Cars;

import java.util.stream.Collectors;

public class ResultView {
    public void printCars(Cars cars) {
        for (Car car : cars.getCars()) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    public void printWinners(Cars cars) {
        for (Car car : cars.getCars()) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        String winners = cars.getWinners().stream().map(Car::getName).collect(Collectors.joining(","));
        System.out.println(winners + "가 최종 우승했습니다.");
    }
}
