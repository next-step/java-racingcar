package racing.view;

public class PositionRecordView {

    private final String RACE_STATUS_STRING = "-";
    private final String RACE_NAME_POINTER_STRING = " : ";
    private final StringBuilder currentPosition = new StringBuilder();
    private final int recordValue;
    private final String name;

    public PositionRecordView(String name, int recordValue) {
        this.name = name;
        this.recordValue = recordValue;
    }

    public String createMessage() {
        currentPosition.setLength(0);
        currentPosition.append(name);
        currentPosition.append(RACE_NAME_POINTER_STRING);
        for (int i = 0; i < recordValue; i++) {
            currentPosition.append(RACE_STATUS_STRING);
        }

        return currentPosition.toString();
    }
}
