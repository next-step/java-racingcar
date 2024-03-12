package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RacingRecord {
    private final List<Cars> records;
    private final List<Car> winners;

    public RacingRecord(int capacity) {
        if (capacity < 1) {
            throw new IllegalArgumentException("1이상 입력해주세요");
        }

        this.records = new ArrayList<>(capacity);
        this.winners = new ArrayList<>();
    }

    public void save(Cars cars) {
        this.records.add(cars);
    }

    public void saveWinners(List<Car> winners) {
        this.winners.addAll(winners);
    }

    public List<Cars> getRecords() {
        return Collections.unmodifiableList(this.records);
    }

    public List<Car> getWinners() {
        return Collections.unmodifiableList(this.winners);
    }
}
