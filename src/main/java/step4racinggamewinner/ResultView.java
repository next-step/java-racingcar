package step4racinggamewinner;

import java.util.List;
import java.util.Map;

public class ResultView {
    private final static String GO = "-";
    private final static String STOP = "";
    public static final String CAR_RESULT_DISPLAY = "-";

    public static void printPreview() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public static void printCurrentCarPosition(Map<String, Integer> currentCarNameAndPosition) {
        for (String carName : currentCarNameAndPosition.keySet()) {
            System.out.printf("%s : %s", carName, convertPositionToStringLine(currentCarNameAndPosition.get(carName)));
            System.out.println();
        }
        System.out.println();
    }

    public static String moveStopDecision(char randomNumber) {
        return Integer.parseInt(String.valueOf(randomNumber)) >= 4 ? GO : STOP;
    }

    public static String convertPositionToStringLine(int position) {
        StringBuilder positionResult = new StringBuilder();
        for (int i = 0; i < position; i++) {
            positionResult.append(CAR_RESULT_DISPLAY);
        }
        return positionResult.toString();
    }


    public static void printWinner(List<String> winnerList) {
        String winnerNames = String.join(", ", winnerList);
        System.out.printf("%s가 최종 우승했습니다.", winnerNames);
    }

}
