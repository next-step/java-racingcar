package racing;

import java.util.List;

public class ResultView {

    private static final String RESULT = "\n실행 결과";
    private static final String TRACE = "-";


    public static void printResult(List<List<Integer>> result) {
        print(RESULT);
        printGameResult(result);
    }

    private static void printGameResult(List<List<Integer>> result) {
        for (List<Integer> roundResult : result) {
            printRoundResult(roundResult);
            print("");
        }
    }

    private static void printRoundResult(List<Integer> roundResult) {
        for (Integer carPosition : roundResult) {
            print(drawTrace((carPosition)));
        }
    }

    private static String drawTrace(int carPosition) {
        return TRACE.repeat(carPosition);
    }

    private static void print(String message) {
        System.out.println(message);
    }

}
