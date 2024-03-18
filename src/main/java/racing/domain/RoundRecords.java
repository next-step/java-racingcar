package racing.domain;

import java.util.Collections;
import java.util.List;

public class RoundRecords {

    private List<RoundRecord> records;

    public RoundRecords(List<RoundRecord> roundRecords) {
        this.records = roundRecords;
    }

    public List<String> findWinner() {
        RoundRecord lastRoundRecord = this.records.get(this.records.size() - 1);
        return lastRoundRecord.findMaxPosition();
    }

    public int size() {
        return records.size();
    }

    public List<RoundRecord> getValue() {
        return Collections.unmodifiableList(records);
    }
}
