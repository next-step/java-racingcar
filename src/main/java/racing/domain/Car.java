package racing.domain;


import java.util.ArrayList;
import java.util.List;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class Car {

    private static final int NAME_LIMIT = 5;

    private final String name;
    private int distance;
    private final List<Integer> status = new ArrayList<>();

    public Car(String name) {
        this.name = name;
        this.distance = 0;
        lengthCheck(name);
    }

    public String carName() { return  name; }

    public int carDistance() {
        return distance;
    }

    public List<Integer> carStatus() {
        return status;
    }

    private void record(int distance) {
        this.status.add(distance);
    }

    public Boolean equalDistance(int distance) {
        if (this.distance == distance) {
            return TRUE;
        }
        return FALSE;
    }

    private void lengthCheck(String names) {
        if (count(name) == FALSE) {
            throw new IllegalArgumentException("자동차 이름은 1자 이상 5자 이하로 입력하세요.");
        }
    }

    private Boolean count(String name) {
        if (name.isEmpty() || name.length() > NAME_LIMIT) {
            return FALSE;
        }
        return TRUE;
    }

    public void move(MoveCondition moveCondition) {
        if (moveCondition.move()) {
            distance += 1;
        }
        record(distance);
    }
}
