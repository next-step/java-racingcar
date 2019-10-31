package racing;

import java.util.List;

public class RacingOutput {
    private static final String RESULT_MESSAGE = "실행결과";
    private static final String DEFAULT_STATUS_OUTPUT_FORMAT = "%s : ";
    private static final String POSITION_SIGNATURES = "-";
    private static final String WINNER_MESSAGE_FORMAT = "%s가 최종 우승했습니다.";
    private static final String WINNER_NAME_SEPARATOR = ", ";

    public void printResultMessage() {
        System.out.println(RESULT_MESSAGE);
    }

    public void printCurrentStatus(Racers racers) {
        for (int i = 0; i < racers.size(); i++) {
            printPosition(racers.getRacerName(i), racers.getPosition(i));
        }
        System.out.println();
    }

    private void printPosition(String racerName, int position) {
        String defaultStatusOutput = String.format(DEFAULT_STATUS_OUTPUT_FORMAT, racerName);
        StringBuilder stringBuilder = new StringBuilder(defaultStatusOutput);
        for (int i = 0; i < position; i++) {
            stringBuilder.append(POSITION_SIGNATURES);
        }

        System.out.println(stringBuilder);
        System.out.println();
    }

    public void printWinner(List<String> racers) {
        String winnerName = String.join(WINNER_NAME_SEPARATOR, racers);
        System.out.println(String.format(WINNER_MESSAGE_FORMAT, winnerName));
    }
}
