package racingcar.view;

import racingcar.domain.*;

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

        for (RoundLog roundLog : roundLogs) {
            printRound(roundLog);
            newLine();
        }
    }

    private static void printRound(RoundLog roundLog) {
        List<Car> history = roundLog.getHistory();

        for (Car car : history) {
            printCarName(car);

            IntStream.rangeClosed(1, car.currentPosition().getPosition())
                    .mapToObj(value -> MOVE_SYMBOL)
                    .forEach(System.out::print);

            newLine();
        }
    }

    private static void printCarName(Car car) {
        System.out.print(car.carName() + " : ");
    }

    public static void printWinners(Winners winners) {
        List<String> winnerList = winners.getWinners()
                .stream()
                .map(Car::carName)
                .collect(Collectors.toList());

        newLine();
        System.out.print(String.join(", ", winnerList) + WINNERS);
    }

    private static void newLine() {
        System.out.println();
    }
}
