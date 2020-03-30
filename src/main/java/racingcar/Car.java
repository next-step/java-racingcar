package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private int position;
    private final List<Integer> record;

    public Car() {
        position = 0;
        record = new ArrayList<>();
    }

    public void move() {
        record.add(++position);
    }

    public List<Integer> getRecord() {
        return new ArrayList<>(record);
    }
}
