package racing.util;

public class PositionRecordView {

    private final String RACE_STATUS_STRING = "-";
    private final StringBuilder currentPosition = new StringBuilder();
    private final int recordValue;

    public PositionRecordView(int recordValue) {
        this.recordValue = recordValue;
    }

    public String createView() {
        currentPosition.setLength(0);
        for (int i = 0; i < recordValue; i++) {
            currentPosition.append(RACE_STATUS_STRING);
        }

        return currentPosition.toString();
    }
}
