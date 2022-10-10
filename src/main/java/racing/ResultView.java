package racing;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    private static final String DISTANCE_CHARACTER = "-";
    private static final String ROUND = "라운드";
    private static final String RESULT_TITLE = "실행 결과";

    public static void printRound(int index) {
        System.out.println(ROUND + " " + index);
    }

    public static void printResultTitle() {
        System.out.println(RESULT_TITLE);
    }

    public static void printDistance(String name, int distance) {
        System.out.println(generateDistanceToString(name, distance));
    }

    private static String generateDistanceToString(String name, int distance) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(name);
        stringBuilder.append(": ");
        for (int i = 0; i < distance; i++) {
            stringBuilder.append(DISTANCE_CHARACTER);
            if (distance == 1) break;
        }

        return stringBuilder.toString();
    }

    public static void printNewLine() {
        System.out.println();
    }

    public static void printWinners(List<String> winnerNames) {
        String names = String.join(",", winnerNames);
        String msg = String.format("%s가 최종 우승했습니다.", names);
        System.out.println(msg);
    }
}
