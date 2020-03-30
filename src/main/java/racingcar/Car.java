package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private int position;
    private final List<Integer> record;
    private final Engine engine;

    public Car(Engine engine) {
        position = 0;
        record = new ArrayList<>();
        this.engine = engine;
    }

    public void move() {
        if (engine.generateNumber() >= 4) {
            position++;
        }
        record.add(position);
    }

    public List<Integer> getRecord() {
        return new ArrayList<>(record);
    }
}
