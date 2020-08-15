package step3.view;

import step3.domain.Car;
import step3.domain.Winners;

import java.util.List;
import java.util.Map;

public class ResultView {

    private static final String GAME_RESULT = "게임 결과";
    private static final String PRINT_WINNER_TEXT = "가 최종 우승했습니다.";
    public static final String WINNERS_COMMA_DELIMITER = ", ";
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

    public static String printWinner(List<String> winnerNames) {
        return String.join(WINNERS_COMMA_DELIMITER, winnerNames) + PRINT_WINNER_TEXT;
    }

    public static String printCarMileAge(Car car, String mileAge) {
        return car.getCarName() + " : " + mileAge;
    }

}
