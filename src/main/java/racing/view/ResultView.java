package racing.view;

import java.util.List;

public class ResultView {
    private static String CAR_STATE_STR = "-";

    public static void printRacingResult(String result) {
        System.out.println(result);
    }

    public static String positionToString(int times) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < times; i++) {
            stringBuilder.append(CAR_STATE_STR);
        }
        stringBuilder.append("\n");

        return stringBuilder.toString();
    }
}
