package racing;

public class ResultView {
    private static final String DISTANCE_CHARACTER = "-";
    private static final String ROUND = "라운드";
    private static final String RESULT_TITLE = "실행 결과";

    private static StringBuilder stringBuilder;

    public static void printRound(int index) {
        System.out.println(ROUND + " " + index);
    }

    public static void printResult() {
        System.out.println(RESULT_TITLE);
    }

    public static void printDistance(int distance) {
        System.out.println(generateDistanceToString(distance));
    }

    private static String generateDistanceToString(int distance) {
        if (distance == 0) return "";

        stringBuilder = new StringBuilder();
        for (int i = 0; i < distance; i++) {
            stringBuilder.append(DISTANCE_CHARACTER);
            if (distance == 1) break;
        }

        return stringBuilder.toString();
    }

    public static void printNewLine() {
        System.out.println();
    }
}
