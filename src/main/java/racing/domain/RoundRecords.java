package racing.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RoundRecords {
    private List<Cars> records;

    RoundRecords() {
        this.records = new ArrayList<>();
    }

    void addRoundRecord(final Cars record) {
        records.add(new Cars(record));
    }

    public List<Cars> getEntrieRecords() {
        return Collections.unmodifiableList(records);
    }

    public Cars getLastResult() {
        return records.get(records.size() - 1);
    }
}
