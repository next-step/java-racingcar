package step4;

import java.util.List;

public class OutputView {

    private static final String ACTION_RESULT = "실행 결과";
    private static final String WIN_RESULT_POSTFIX = "가 최종 우승했습니다.";

    public static void printResult(RacingCars racingCars, boolean isFirstTry) {
        if (isFirstTry) {
            System.out.println(ACTION_RESULT);
        }
        System.out.println(CarsStatusHelper.getCarsStatusView(racingCars));
    }

    public static void printWinner(List<String> winners) {
        System.out.println(String.join(", ", winners) + WIN_RESULT_POSTFIX);
    }

}
