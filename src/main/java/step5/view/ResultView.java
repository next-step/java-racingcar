package step5.view;

import step5.domain.Car;

import java.util.List;

public class ResultView {

    public static final String RESULT_TEXT = "실행 결과";
    public static final String FORWARD_TEXT = "-";
    public static final String END_TEXT = "";
    public static final String NAME_SEPARATOR = ", ";

    public static void printResult(Car car) {
        System.out.println(car.name + NAME_SEPARATOR + FORWARD_TEXT.repeat(car.location));
    }

    public static void printRacingStart() {
        System.out.println(RESULT_TEXT);
    }

    public static void printRacingCycleEnd() {
        System.out.println(END_TEXT);
    }

    public static void printWinner(List<Car> winners) {
        String winnerString = "";
        for (Car winner : winners) {
            winnerString = getWinnerString(winner, winnerString);
        }
        System.out.println(winnerString + "가 최종 우승했습니다.");
    }

    private static String getWinnerString(Car car, String winner) {
        if (!winner.isBlank()) {
            winner += NAME_SEPARATOR;
        }
        winner += car.name;
        return winner;
    }
}

