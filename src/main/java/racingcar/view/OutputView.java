package racingcar.view;

import racingcar.race.RacingScorecard;

import java.util.List;

public class OutputView {

    private static final String TEXT_TITLE = "\n실행결과";
    private static final String TEXT_WINNER ="가 최종 우승했습니다.";
    private static final String TEXT_SEPARATOR_BETWEEN_NAMES = ", ";
    private OutputView() {

    }

    public static void printTitle() {
        System.out.println(TEXT_TITLE);
    }

    public static void printRaceResultByTime(List<RacingScorecard> raceResults) {
        for (RacingScorecard result : raceResults) {
            draw(result.getName(), result.getPosition());
        }
        System.out.println();
    }

    private static void draw(String name, int position) {
        System.out.print(name + " : ");
        for (int i = 0 ; i < position ; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public static void printWinner(List<RacingScorecard> winner) {
        StringBuilder printString = new StringBuilder();
        for (RacingScorecard result : winner) {
            printString.append(result.getName()).append(TEXT_SEPARATOR_BETWEEN_NAMES);
        }

        final int endIndex = printString.length();
        printString.delete(endIndex - TEXT_SEPARATOR_BETWEEN_NAMES.length(), endIndex).append(TEXT_WINNER);
        System.out.println(printString);
    }

}
