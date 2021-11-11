package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.GameLog;
import racingcar.domain.RoundLog;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OutputView {
    private static final String CAR_COUNT_EXCEPTIONM_ESSAGE = "자동차 생성 숫자는 0 이상 입력";
    private static final String TRY_COUNT_EXCEPTIONM_ESSAGE = "시도할 회수는 0 이상 입력";
    private static final String WINNERS = "가 최종 우승했습니다.";
    private static final String MOVE_SYMBOL = "-";

    private OutputView() {
    }

    public static void printCarCountExceptionMessage() {
        System.out.println(CAR_COUNT_EXCEPTIONM_ESSAGE);
    }

    public static void printTryCountExceptionMessage() {
        System.out.println(TRY_COUNT_EXCEPTIONM_ESSAGE);
    }

    public static void printGameLog(GameLog gameLog) {
        List<RoundLog> roundLogs = gameLog.getRoundLogs();
        int currentRound = roundLogs.get(0).round();

        for (RoundLog roundLog : roundLogs) {
            if (currentRound != roundLog.round()) {
                newLine();
                currentRound = roundLog.round();
                printRound(roundLog);
                continue;
            }
            printRound(roundLog);
        }
    }

    private static void printRound(RoundLog roundLog) {
        System.out.print(roundLog.carName() + " : ");
        IntStream.rangeClosed(1, roundLog.position())
                .mapToObj(value -> MOVE_SYMBOL)
                .forEach(System.out::print);
        newLine();
    }

    public static void printWinners(Cars cars) {
        List<String> winners = cars.findWinners()
                .stream()
                .map(Car::carName)
                .collect(Collectors.toList());

        System.out.print(String.join(", ", winners));

        System.out.print(WINNERS);
    }

    private static void newLine() {
        System.out.println();
    }
}
