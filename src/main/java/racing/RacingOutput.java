package racing;

public class RacingOutput {
    private static final String RESULT_MESSAGE = "실행결과";
    private static final String POSITION_SIGNATURES = "-";

    public static void printResultMessage() {
        System.out.println(RESULT_MESSAGE);
    }

    public static void printCurrentStatus(Racers racers) {
        for (int i = 0; i < racers.size(); i++) {
            printPosition(racers.getPosition(i));
        }
        System.out.println();
    }

    private static void printPosition(int position) {
        for (int i = 0; i < position; i++) {
            System.out.print(POSITION_SIGNATURES);
        }
        System.out.println();
    }
}
