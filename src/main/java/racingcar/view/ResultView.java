package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.PlayResult;

import java.util.Arrays;
import java.util.List;

public class ResultView {

    public static final String RESULT_MESSAGE = "-";
    public static final String BRACKETS_REGEX = "\\[|\\]";

    public static void printTitle() {
        printNewLine();
        System.out.println("실행 결과");
    }

    public static void printPlayResults(List<PlayResult> playResults) {
        for (PlayResult playResult : playResults) {
            System.out.println(playResult.getNameValue() + " : "
                    + resolvePositionResultMessage(playResult.getPositionValue()));
        }
        printNewLine();
    }

    private static String resolvePositionResultMessage(int position) {
        return RESULT_MESSAGE.repeat(Math.max(0, position));
    }

    public static void printWinners(List<PlayResult> playResults) {
        System.out.println(mapArrayToString(playResults.stream().map(PlayResult::getNameValue).toArray()) +
                "가 최종 우승했습니다.");
    }

    public static String mapArrayToString(Object[] list) {
        return removeBrackets(Arrays.toString(list));
    }

    public static String removeBrackets(String text) {
        return text.replaceAll(BRACKETS_REGEX, "");
    }

    private static void printNewLine() {
        System.out.println();
    }
}
