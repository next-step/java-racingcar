package racingcarRefactor.view;

public class ResultView {
    private final static String DRIVING_MARK = "-";
    private final static String NEW_LINE = "\n";
    private final static String WINNER_ANNOUNCE = "최종 우승자 : ";

    public static void displayRound(String carName, int distance) {
        displayCarName(carName);
        displayDrivingDistance(distance);
    }

    public static void endOfRound() {
        System.out.print(NEW_LINE);
    }

    public static void displayWinner(String winners) {
        System.out.printf(WINNER_ANNOUNCE + " %s%n", winners);
    }

    private static void displayCarName(String carName) {
        System.out.print(carName + " : ");
    }

    private static void displayDrivingDistance(int distance) {
        for (int i = 0; i <= distance; i++) {
            System.out.print(DRIVING_MARK);
        }
        System.out.print(NEW_LINE);
    }
}
