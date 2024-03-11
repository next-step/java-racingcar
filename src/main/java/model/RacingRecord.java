package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RacingRecord {
    private final List<Cars> records;
    private final List<String> winners;

    public RacingRecord(int capacity) {
        this.records = new ArrayList<>(capacity);
        this.winners = new ArrayList<>();
    }

    public void save(Cars cars) {
        this.records.add(cars);
    }

    public List<Cars> getRecords() {
        return Collections.unmodifiableList(this.records);
    }

    public List<String> getWinners() {
        return Collections.unmodifiableList(this.winners);
    }

    public void saveWinners(List<String> winners) {
        this.winners.addAll(winners);
    }
}
