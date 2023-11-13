package study.step5.view;

import java.util.List;
import java.util.stream.Collectors;

import study.step5.domain.Car;
import study.step5.domain.Cars;

public class ResultView {

    public static void showProgress(Cars cars) {
        cars.getCars()
            .forEach(car -> System.out.println(car.name() + " : " + "-".repeat(car.position().getPosition())));
        System.out.println();
    }

    public static void showResult(Cars cars) {
        List<String> winnerNames = cars.getCars().stream()
            .map(Car::name)
            .collect(Collectors.toList());
        System.out.println(String.join(", ", winnerNames) + "가 최종 우승했습니다.");
    }
}
