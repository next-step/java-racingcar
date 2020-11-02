package step3.domain;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private Integer position;
    private final List<Integer> record;

    public Car(Integer position) {
        this.position = position;
        record = new ArrayList<>();
    }

    public void move() {
        position += 1;
        record.add(position);
    }

    public Integer getPosition() {
        return position;
    }

    public Integer getRecordAtStep(int step) {
        return record.get(step);
    }

    public int getRecordCount() {
        return record.size();
    }
}
