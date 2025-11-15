package study.racing.view;

import study.racing.domain.Car;

import java.util.List;

public class GameOutput {

    public static void printResult() {
        System.out.println("실행 결과");
    }

    public static void printRound(List<Car> cars) {
        for (Car car : cars) {
            printCar(car);
        }
    }

    private static void printCar(Car car) {
        System.out.print(car.getName() + " : ");
        printPosition(car.getPosition());
    }

    private static void printPosition(int position) {
        for (int i = 0; i < position; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public static void printEmptyLine() {
        System.out.println();
    }

    public static void printWinners(List<String> winners) {
        String winnerNames = String.join(", ", winners);
        System.out.println(winnerNames + "가 최종 우승했습니다.");
    }
}
