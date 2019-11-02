package racingcar.view;

import racingcar.domain.Car;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    public static void printResult() {
        System.out.println("\n실행 결과");
    }

    public static void printCars(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + getDistanceIndicator(car));
        }
        System.out.println();
    }

    private static StringBuilder getDistanceIndicator(Car car) {
        StringBuilder stringBuilder = new StringBuilder();
        int totalDistance = car.getDistance();
        for (int i = 0; i < totalDistance; i++) {
            stringBuilder.append("-");
        }
        return stringBuilder;
    }

    public static void printWinners(List<Car> winners) {
        List<String> winnerNames = winners.stream()
                .map(Car::getName)
                .collect(Collectors.toList());
        System.out.println(String.join(", ", winnerNames) + " 가 최종 우승했습니다.");
    }
}