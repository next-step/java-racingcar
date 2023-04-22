package race.step4.model;

import java.util.List;
import java.util.stream.Collectors;

public class RecordGroup {
    private final List<Record> records;
    private final List<List<Record>> allRecords;
    private static final String COMMA_TEXT = ", ";

    public RecordGroup(List<List<Record>> allRecords) {
        this.allRecords = allRecords;
        this.records = findLastRecord(allRecords);
    }

    public String getWinners() {
        return records.stream()
                .filter(records -> records.getDistance() == getMaxDistance())
                .map(Record::getPlayer)
                .collect(Collectors.joining(COMMA_TEXT));
    }

    public int getMaxDistance() {
        return records.stream()
                .mapToInt(Record::getDistance)
                .max()
                .orElse(0);
    }

    private List<Record> findLastRecord(List<List<Record>> records) {
        return records.get(records.size() - 1);
    }

    public List<List<Record>> getAllRecords() {
        return allRecords;
    }
}
