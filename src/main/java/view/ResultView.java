package view;

import java.util.Arrays;

public class ResultView {

    private final static String BLANK = "";
    private final static String RESULT_MESSAGE = "실행 결과";
    public final static String DISTANCE_BLOCK = "-";

    public static void drawResultView() {
        System.out.println(RESULT_MESSAGE);
        System.out.println(BLANK);
    }

    public static void drawDistanceBlock(int[] eachCarMovedDistance) {
        Arrays.stream(eachCarMovedDistance)
                .forEach(ResultView::drawConsole);
        System.out.println(BLANK);
    }

    public static void drawConsole(int distance) {
        String currentCarDistance = "";
        for (int i = 0; i < distance; i++) {
            currentCarDistance += DISTANCE_BLOCK;
        }
        System.out.println(currentCarDistance);
    }
}
