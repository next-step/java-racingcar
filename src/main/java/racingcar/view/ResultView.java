package racingcar.view;

import racingcar.domain.PlayResult;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    public static final String RESULT_MESSAGE = "-";

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
        String winnerCarNames = playResults.stream()
                .map(PlayResult::getNameValue)
                .collect(Collectors.joining(", "));
        System.out.println(winnerCarNames + "가 최종 우승했습니다.");
    }

    private static void printNewLine() {
        System.out.println();
    }
}
