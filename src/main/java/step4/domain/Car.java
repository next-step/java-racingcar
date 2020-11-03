package step4.domain;

import step4.dto.RecordDto;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private Integer position;
    private final String name;
    private final List<Integer> record;

    public Car(String name) {
        this.name = name;
        position = 0;
        record = new ArrayList<>();
    }

    public void move() {
        position += 1;
    }

    public Integer getPosition() {
        return position;
    }

    public void record() {
        record.add(position);
    }

    public RecordDto getRecordAtStep(int step) {
        return new RecordDto(name, record.get(step));
    }

    public int getRecordCount() {
        return record.size();
    }

    public RecordDto getFinalRecord() {
        return new RecordDto(name, record.get(record.size() - 1));
    }
}
