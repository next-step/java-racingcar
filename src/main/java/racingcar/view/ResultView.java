package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

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
        StringBuilder stringBuilder = new StringBuilder();
        int winnersCount = winners.size();
        for (int i = 0; i < winnersCount; i++) {
            stringBuilder.append(winners.get(i).getName());
            addDelimiter(winners, stringBuilder, i);
        }
        System.out.println(stringBuilder + " 가 최종 우승했습니다.");
    }

    private static void addDelimiter(List<Car> winners, StringBuilder stringBuilder, int i) {
        if (i != winners.size() - 1) {
            stringBuilder.append(", ");
        }
    }
}