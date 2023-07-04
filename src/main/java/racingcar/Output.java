package racingcar;

import java.util.List;

public class Output {

    /** Print initial status. */
    public static void printInitialStatus(List<Car> cars) {
        System.out.println("\n실행 결과"); // another sout or \n in string?
        printCarStatus(cars);
    }

    /** Print status of cars. */
    public static void printCarStatus(List<Car> cars) {
        cars.stream().map(Car::toString).forEach(System.out::println);
        System.out.println();
    }

    /** Print winners. */
    public static void printWinners(List<String> winnerNames) {
        System.out.println(String.join(", ", winnerNames) + "가 최종우승했습니다.");
    }
}
