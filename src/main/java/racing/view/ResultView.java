package racing.view;


import racing.domain.Car;

import java.util.List;
import java.util.StringJoiner;

public class ResultView {

    private ResultView() {
        throw new IllegalStateException("static method class");
    }

    public static void printResultMessage() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public static void printResult(List<Car> cars) {
        for (Car car : cars) {
            printCarResult(car);
        }
        System.out.println();
    }

    private static void printCarResult(Car car) {
        System.out.print(car.getName() + " : ");
        for (int i = 0; i < car.getPosition(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public static void printWinners(List<Car> winners) {
        StringJoiner joiner = new StringJoiner(", ", "", "가 최종 우승했습니다.");

        for (Car winner : winners) {
            joiner.add(winner.getName());
        }
        System.out.print(joiner);
    }
}
