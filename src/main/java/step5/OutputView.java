package step5;

import java.util.List;

public class OutputView {

    private static final String ACTION_RESULT = "실행 결과";
    private static final String WIN_RESULT_POSTFIX = "가 최종 우승했습니다.";

    public static void printActionResult(){
        System.out.println(ACTION_RESULT);
    }

    public static void printResult(int status) {
        System.out.println(CarsStatusHelper.getCarStatusView(status));
    }

    public static void printWinner(List<String> winners) {
        System.out.println(String.join(", ", winners) + WIN_RESULT_POSTFIX);
    }

}
