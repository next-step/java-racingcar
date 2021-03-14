package racingcar.view;


import racingcar.util.ResultDto;

import java.util.List;

public class ResultView {

    private static final String WINNER_DELIMITER = ", ";

    private ResultView() {
    }

    public static void startGame() {
        System.out.println("\n실행 결과");
    }

    public static void showResult(List<ResultDto> resultDtos) {
        resultDtos.stream()
                .map(ResultDto::getResult)
                .forEach(System.out::println);
        printNewLine();
    }

    public static void showWinners(List<String> winnerNames) {
        String names = String.join(WINNER_DELIMITER, winnerNames);
        System.out.println(names + "가 최종 우승했습니다.");
    }

    public static void printNewLine() {
        System.out.println();
    }
}
