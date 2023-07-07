package racingcar.view;

import racingcar.domain.CarName;
import racingcar.domain.CarStatus;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    private static final String COLON = " : ";
    private static final String POSITION_STRING = "-";

    public static void printInitialStatus(List<CarStatus> initialStatus) {
        System.out.println();
        System.out.println("실행 결과");
        printCarStatus(initialStatus);
    }

    public static void printGameStatus(List<List<CarStatus>> gameStatus) {
        gameStatus.forEach(OutputView::printCarStatus);
    }

    public static void printCarStatus(List<CarStatus> raceStatus) {
        raceStatus.stream()
                .map(OutputView::carStatusToString)
                .forEach(System.out::println);
        System.out.println();
    }

    private static String carStatusToString(CarStatus carStatus) {
        return carStatus.getName() + COLON + POSITION_STRING.repeat(carStatus.getPosition());
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
