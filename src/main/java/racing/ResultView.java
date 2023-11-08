package racing;

import java.util.Map;

public class ResultView {
    private static final String NUMBER = "number";
    private static final String COUNT = "count";
    private static String[][] result;

    public static void init(Map<String, Integer> input) {
        result = new String[input.get(COUNT)][input.get(NUMBER)];
    }

    public static void concat(int i, int j, String value) {
        result[i][j] = i > 0 ? result[i - 1][j].concat(value) : String.valueOf(value);
    }

    public static void racingResult() {
        for (String[] strings : result) {
            for (String string : strings) {
                System.out.println(string);
            }
            System.out.print("\n");
        }
    }
}
