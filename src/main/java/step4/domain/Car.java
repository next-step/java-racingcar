package step4.domain;

import step4.RecordDto;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private Integer position;
    private final String name;
    private final List<Integer> record;

    public Car(Integer position) {
        this.position = position;
        this.name = "";
        record = new ArrayList<>();
    }

    public Car(String name, Integer position) {
        this.name = name;
        this.position = position;
        record = new ArrayList<>();
    }

    public void move() {
        position += 1;
    }

    public void record() {
        record.add(position);
    }

    public Integer getPosition() {
        return position;
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
