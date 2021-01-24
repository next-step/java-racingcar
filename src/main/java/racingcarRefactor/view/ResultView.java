package racingcarRefactor.view;

public class ResultView {
    private final static String DRIVING_MARK = "-";
    private final static String NEW_LINE = "\n";
    private final static String WINNER_ANNOUNCE = "최종 우승자 : ";

    public static void displayRound(String driver, int distance) {
        displayDriver(driver);
        displayDrivingDistance(distance);
    }

    public static void displayDriver(String driver) {
        System.out.print(driver + " : ");
    }

    private static void displayDrivingDistance(int distance) {
        for (int i=0; i<=distance; i++) {
            System.out.print(DRIVING_MARK);
        }
        System.out.print(NEW_LINE);
    }

    public static void displayWinner(String winner) {
        System.out.print(WINNER_ANNOUNCE + winner);
    }
}
