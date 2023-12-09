package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Car {
    private final static int MOVE_CONDITION = 4;
    private int position;

    public Car(int position) {
        this.position = position;
    }

    public static List<Car> makeCarsBy(int carCount) {
        return IntStream.range(0, carCount)
                        .mapToObj(i -> new Car(1))
                        .collect(Collectors.toList());
    }

    public int getPosition() {
        return position;
    }

    public void moveForwardByCondition(int randomNumber) {
        if (isMovable(randomNumber)) {
            this.position++;
        }
    }

    private boolean isMovable(int randomNumber) {
        return randomNumber >= MOVE_CONDITION;
    }
}
