package racing.view;

import java.util.List;

public class ResultView {
    private static String CAR_STATE_STR = "-";
    private static String RESULT_INFO_COMMENT = "\n실행 결과";

    public static void printResultInfoComment() {
        System.out.println(RESULT_INFO_COMMENT);
    }

    public static void printCarsState(List<Integer> states) {
        for (int state : states) {
            printStringAsManyAsGiven(state);
        }

        System.out.println("");
    }

    private static void printStringAsManyAsGiven(int times) {
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < times; i++) {
            sb.append(CAR_STATE_STR);
        }

        System.out.println(sb.toString());
    }
}
