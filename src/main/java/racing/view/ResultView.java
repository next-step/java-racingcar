package racing.view;

import java.util.List;

public class ResultView {
    private static String CAR_STATE_STR = "-";

    public static void printString(String string) {
        System.out.println(string);
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
