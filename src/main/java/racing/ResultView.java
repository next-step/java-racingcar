package racing;

public class ResultView {
    private static final String DISTANCE_CHARACTER = "-";
    private static final String ROUND = "라운드";
    private static final String RESULT_TITLE = "실행 결과";

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
        String stringDistance = "";
        if (distance == 0) { return stringDistance; }
        if (distance == 1) { return concatDistance(stringDistance); }

        for (int i = 0; i < distance; i++) {
            stringDistance = concatDistance(stringDistance);
        }

        return stringDistance;
    }

    private static String concatDistance(String str) {
        return str.concat(DISTANCE_CHARACTER);
    }

    public static void printNewLine() {
        System.out.println();
    }
}
