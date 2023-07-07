package racingcar.view;

import racingcar.domain.CarName;
import racingcar.domain.CarStatus;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    private static final String COLON = " : ";
    private static final String POSITION_STRING = "-";

    private OutputView() {
        throw new IllegalStateException("Utility class");
    }

    public static void printResult(List<List<CarStatus>> gameStatus, List<CarName> winnerNames) {
        printTitle();
        printGameStatus(gameStatus);
        printWinners(winnerNames);
    }

    private static void printTitle() {
        System.out.println();
        System.out.println("실행 결과");
    }

    private static void printGameStatus(List<List<CarStatus>> gameStatus) {
        gameStatus.forEach(OutputView::printCarStatus);
    }

    private static void printCarStatus(List<CarStatus> raceStatus) {
        raceStatus.stream()
                .map(OutputView::carStatusToString)
                .forEach(System.out::println);
        System.out.println();
    }

    private static String carStatusToString(CarStatus carStatus) {
        return carStatus.getName() + COLON + POSITION_STRING.repeat(carStatus.getPosition());
    }

    private static void printWinners(List<CarName> winnerNames) {
        System.out.println(carNamesToString(winnerNames) + "가 최종우승했습니다.");
    }

    private static String carNamesToString(List<CarName> carNames) {
        return carNames.stream()
                .map(CarName::getName)
                .collect(Collectors.joining(", "));
    }
}
