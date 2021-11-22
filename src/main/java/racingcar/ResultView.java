package racingcar;

public class ResultView {
    private static final String DISTANCE_PATTERN = "-";

    public static void printCarDistance(int distance) {
        for(int i = 0; i < distance; i++) {
            System.out.print(DISTANCE_PATTERN);
        }
        System.out.println();
    }

    public static void printCarDistanceWithName(int distance, String name) {
        System.out.printf("%s : ", name);
        for(int i = 0; i < distance; i++) {
            System.out.print(DISTANCE_PATTERN);
        }
        System.out.println();
    }

    public static void println(String message) {
        System.out.println(message);
    }

    public static void printWinners(String winners) {
        System.out.printf("%s가 최종 우승했습니다.", winners);
    }

}
