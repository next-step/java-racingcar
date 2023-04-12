package step3;

import java.util.List;

public class ResultView {

    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String DELIMITER_FOR_WINNER = ",";
    private static final String FINAL_WINNER_MESSAGE = "가 최종 우승했습니다.";

    public static void newLine() {
        System.out.println();
    }

    public static void printResultMessage() {
        newLine();
        System.out.println(RESULT_MESSAGE);
    }

    public static void printEachResult(List<String> result) {
        for (String each : result) {
            System.out.println(each);
        }
        newLine();
    }

    public static void printWinner(List<String> winnerList) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String eachWinner : winnerList) {
            stringBuilder.append(eachWinner);
            stringBuilder.append(DELIMITER_FOR_WINNER);
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        stringBuilder.append(FINAL_WINNER_MESSAGE);
        System.out.println(stringBuilder);
    }

}