package racing.view;

import racing.domain.Car;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    public static void printWinners(List<Car> carList) {
        String collect = carList.stream()
                .map(Car::getName)
                .collect(Collectors.joining(","));
        System.out.println(collect + "가 최종 우승했습니다.");
    }
}