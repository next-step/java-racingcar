package carracing.logic.type;

import java.util.List;

public class Record {
    private final List<String> recordStringList;

    public Record(List<String> recordStringList) {
        this.recordStringList = recordStringList;
    }

    public List<String> toList() {
        return recordStringList;
    }
}
