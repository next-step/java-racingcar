package camp.nextstep.edu.rebellion.racing;

import java.util.ArrayList;
import java.util.List;

public class Record {
    private final List<String> recordLane = new ArrayList<>();
    public void keep(Entry entry) {
        recordLane.add(entry.getAllPositionLanes());
    }

    public List<String> getRecordLane() {
        return recordLane;
    }
}
