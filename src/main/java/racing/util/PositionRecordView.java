package racing.util;

public class PositionRecordView {

    private static final String RACE_STATUS_STRING = "-";
    private static final StringBuilder currentPosition = new StringBuilder();

    public static String of(int position) {
        currentPosition.setLength(0);
        for (int i = 0; i < position; i++) {
            currentPosition.append(RACE_STATUS_STRING);
        }

        return currentPosition.toString();
    }
}
