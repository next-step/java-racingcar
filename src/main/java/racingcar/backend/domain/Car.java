package racingcar.backend.domain;

import java.util.Collections;
import java.util.Map;

public class Car {

    private static final int ZERO = 0;
    private static final String ANONYMOUS = "익명";
    private Position position;
    private CarName carName;

    public Car() {
        this(ANONYMOUS, ZERO);
    }

    public Car(String name) {
        this(name, ZERO);
    }

    public Car(String name, int position) {
        this.carName = new CarName(name);
        this.position = new Position(position);
    }

    public Map<String, Integer> move(MoveStrategy moveStrategy) {
        if (moveStrategy.movable()) {
            position.forward();
        }
        return getRecord();
    }

    public int getPosition() {
        return position.getValue();
    }

    public String getName() {
        return carName.getValue();
    }

    private Map<String, Integer> getRecord() {
        return Collections.singletonMap(getName(), getPosition());
    }
}
