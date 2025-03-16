package view;

import java.util.List;

public class ResultView {
    private static final String MOVE_SIGN = "-";
    public static void print(List<Integer> positions) {
        for (Integer position : positions) {
            System.out.println(convert(position));
        }
        System.out.println();
    }

    private static String convert(int position) {
        return MOVE_SIGN.repeat(Math.max(0, position));
    }
}
