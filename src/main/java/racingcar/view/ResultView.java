package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.History;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    public static void printResult() {
        System.out.println("\n실행 결과");
    }

    public static void printCars(final History history) {
        final int tryCount = history.size();
        for (int i = 0; i < tryCount; i++) {
            getCarHistoryRow(history, i);
        }
    }

    private static void getCarHistoryRow(History history, int i) {
        List<Car> cars = history.get(i);
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