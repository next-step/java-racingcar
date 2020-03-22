package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.CarRoundLog;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    private static final String SCOREBOARD = "-";
    private static final String WINNER_PRINT = " 가 최종 우승했습니다.";

    public static void printCarRoundLogs(List<CarRoundLog> carRoundLogs) {
        for (CarRoundLog carRoundLog : carRoundLogs) {
            printCarRoundLog(carRoundLog);

            System.out.println("");
        }
    }

    public static void printWinner(List<Car> winner) {
        String winnerNames = winner.stream().map(car -> car.getName()).collect(Collectors.joining(","));

        System.out.println(winnerNames + WINNER_PRINT);
    }

    private static void printCarRoundLog(CarRoundLog carRoundLog) {
        carRoundLog.getCarLogs().stream()
                .forEach(carLog -> System.out.println(carLog.getName() + " : " + String.join("", Collections.nCopies(carLog.getPosition(), SCOREBOARD))));
    }
}
