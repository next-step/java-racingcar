package racingCar.view;

import racingCar.domain.Car;
import racingCar.domain.Cars;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    public static void output() {
        System.out.println("실행결과");
    }

    public static void position(Cars cars) {
        for (Car car : cars.getCars()) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    public static void result(List<Car> winners) {
        String winnerNames = winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));

        System.out.println(winnerNames + "가 최종 우승했습니다.");
    }

}
