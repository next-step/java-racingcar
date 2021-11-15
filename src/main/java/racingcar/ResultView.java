package racingcar;

public class ResultView {
    private static final String DISTANCE_PATTERN = "-";

    public static void printCarDistance(int distance) {
        for(int i = 0; i < distance; i++) {
            System.out.print(DISTANCE_PATTERN);
        }
        System.out.println();
    }

    public static void println(String message) {
        System.out.println(message);
    }

}
