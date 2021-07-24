package racing.domain;

import java.util.ArrayList;
import java.util.List;

public class PositionRecord {
    private final List<Integer> status;

    public PositionRecord() {
        this.status = new ArrayList<>();
    }

    public void save(int position) {
        status.add(position);
    }

    public int getRecordStatus(int index) {
        return status.get(index);
    }

}
