package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class Output {

    public static void printInitialStatus(Cars cars) {
        System.out.println();
        System.out.println("실행 결과"); // another sout or \n in string?
        printCarStatus(cars);
    }

    public static void printCarStatus(Cars cars) {
        cars.mapToStatus()
                .stream()
                .map(Output::carStatusToString)
                .forEach(System.out::println);
        System.out.println();
    }

    private static String carStatusToString(CarStatus carStatus) {
        return carStatus.getName() + " : " + "-".repeat(carStatus.getPosition());
    }

    public static void printWinners(List<CarName> winnerNames) {
        System.out.println(carNamesToString(winnerNames) + "가 최종우승했습니다.");
    }

    private static String carNamesToString(List<CarName> carNames) {
        return carNames.stream()
                .map(CarName::getName)
                .collect(Collectors.joining(", "));
    }
}
