package racing.domain;

import java.util.ArrayList;
import java.util.List;

public class PositionRecord {
    private final List<Integer> status;
    private final StringBuilder currentPosition;

    public PositionRecord() {
        this.status = new ArrayList<>();
        this.currentPosition = new StringBuilder();
    }

    public void save(int position) {
        status.add(position);
    }

    public int getRecordStatus(int index) {
        return status.get(index);
    }

}
