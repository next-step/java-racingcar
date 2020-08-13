package step3.view;

import step3.domain.Car;
import step3.domain.Winners;

import java.util.Map;

public class ResultView {

    private static final String GAME_RESULT = "게임 결과";
    private static final String PRINT_WINNER_TEXT = "가 최종 우승했습니다.";
    private static String ACCELATE_SIGN = "-";

    public static void gameResult() {
        System.out.println(GAME_RESULT);
    }

    public static String printMovement(int position) {
        String mileAge = "";
        for (int i = 0; i < position; i++) {
            mileAge += ACCELATE_SIGN;
        }
        return mileAge;
    }

    public static String printWinner(Map<String, Car> carInfoMap, int maxPosition) {
        return Winners.findWinner(carInfoMap, maxPosition) + PRINT_WINNER_TEXT;
    }

}
