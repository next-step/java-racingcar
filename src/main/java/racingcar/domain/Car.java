package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private static final int MOVE = 1;
    private static final int DONT_MOVE = 0;

    private final List<Integer> position;

    public Car() {
        this.position = new ArrayList<>();
    }

    public Car(List<Integer> position) {
        this.position = position;
    }

    public Car move(MoveStrategy moveStrategy) {
        if (moveStrategy.isMove()) {
            position.add(MOVE);
        }
        position.add(DONT_MOVE);
        return new Car(position);
    }

    public int getScore() {
        return position.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

}
