package step3racingcarcompetition;

import java.util.List;

public class ResultView {
    private final static String GO = "-";
    private final static String STOP = "";

    public static void printPreview() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public static void printCurrentCarMovement(List<String> currentCarsMovingData) {
        currentCarsMovingData.stream()
                .map(ResultView::convertMovingData)
                .forEach(System.out::println);
        System.out.println();
    }

    public static String moveStopDecision(char randomNumber) {
        return Integer.parseInt(String.valueOf(randomNumber)) >= 4 ? GO : STOP;
    }

    public static String convertMovingData(String movingData) {
        StringBuilder resultData = new StringBuilder();
        for (char eachRoundMovingData : movingData.toCharArray()) {
            resultData.append(moveStopDecision(eachRoundMovingData));
        }
        return resultData.toString();
    }


}
