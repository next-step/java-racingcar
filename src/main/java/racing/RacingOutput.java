package racing;

public class RacingOutput {
    private static final String RESULT_MESSAGE = "실행결과";
    private static final String POSITION_SIGNATURES = "-";
    private static final String DEFAULT_STATUS_OUTPUT_FORMAT = "%s : ";

    public static void printResultMessage() {
        System.out.println(RESULT_MESSAGE);
    }

    public static void printCurrentStatus(Racers racers) {
        for (int i = 0; i < racers.size(); i++) {
            printPosition(racers.getRacerName(i), racers.getPosition(i));
        }
        System.out.println();
    }

    private static void printPosition(String racerName, int position) {
        String defaultStatusOutput = String.format(DEFAULT_STATUS_OUTPUT_FORMAT, racerName);
        StringBuilder stringBuilder = new StringBuilder(defaultStatusOutput);
        for (int i = 0; i < position; i++) {
            stringBuilder.append(POSITION_SIGNATURES);
        }

        System.out.println(stringBuilder);
        System.out.println();
    }
}
