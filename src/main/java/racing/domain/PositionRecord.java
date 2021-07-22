package racing.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PositionRecord {
    private static final String RACE_STATUS_STRING = "-";
    private final List<String> status;
    private final StringBuilder currentPosition;

    public PositionRecord() {
        this.status = new ArrayList<>();
        this.currentPosition = new StringBuilder();
    }

    public void save(int position) {
        currentPosition.setLength(0);
        for (int i = 0; i < position; i++) {
            currentPosition.append(RACE_STATUS_STRING);
        }
        status.add(currentPosition.toString());
    }

    public String getRecordStatus(int index) {
        return status.get(index);
    }

}
