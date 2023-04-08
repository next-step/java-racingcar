package carracing.race.logic.type;

import java.util.List;

public class Record {
    private final List<String> record;

    public Record(List<String> record) {
        this.record = record;
    }

    public List<String> toList() {
        return record;
    }
}
