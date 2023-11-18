package car.view;

import car.model.Car;
import java.util.List;

public class ResultView {
    private static final String CAR_DISTANCE_BAR = "-";
    private static final String EACH_GAME_RESULT_JOIN_COLON = " : ";
    private static final String FINAL_GAME_RESULT_CAR_NAME_JOIN_COLON = ", ";
    private static final String FINAL_GAME_WINNER_MENTION = "가 최종 우승했습니다.";

    public static void outputFinalGameResult(List<String> carNames) {
        System.out.println(String.join(FINAL_GAME_RESULT_CAR_NAME_JOIN_COLON, carNames) + FINAL_GAME_WINNER_MENTION);
    }

    public static void outputEachGameResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(outputCarNameWithDistance(car.getCarName(), makeCarDistance(car.getDistance())));
        }
        System.out.println();
    }

    private static String outputCarNameWithDistance(String carName, String carDistance) {
        return String.join(EACH_GAME_RESULT_JOIN_COLON, carName, carDistance);
    }

    private static String makeCarDistance(Integer distance) {
        return CAR_DISTANCE_BAR.repeat(distance);
    }
}
