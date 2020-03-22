package racingcar.view;

import racingcar.domain.Car;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    private static final String SCOREBOARD = "-";
    private static final String WINNER_PRINT = " 가 최종 우승했습니다.";

    public static void printPosition(String carName, int position) {
        System.out.println(carName + " : " + String.join("", Collections.nCopies(position, SCOREBOARD)));
    }

    public static void printNewLine() {
        System.out.println("");
    }

    public static void printWinner(List<Car> winner) {
        String winnerNames = winner.stream().map(it -> it.getName()).collect(Collectors.joining(","));

        System.out.println(winnerNames + WINNER_PRINT);
    }
}
