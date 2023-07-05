package racingcar;

import java.util.List;

public class Output {

    /** Print initial status. */
    public static void printInitialStatus(List<Car> cars) {
        System.out.println();
        System.out.println("실행 결과"); // another sout or \n in string?
        printCarStatus(cars);
    }

    /** Print status of cars. */
    public static void printCarStatus(List<Car> cars) {
        cars.stream().map(Output::carStatusToString).forEach(System.out::println);
        System.out.println();
    }

    private static String carStatusToString(Car car) {
        return car.getName() + " : " + "-".repeat(car.getPosition());
    }

    /** Print winners. */
    public static void printWinners(List<String> winnerNames) {
        System.out.println(String.join(", ", winnerNames) + "가 최종우승했습니다.");
    }
}
