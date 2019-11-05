package step3.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Car {
    private static final Integer MOVE_POSITION = 1;
    private static final Integer ZERO_POSITION = 0;
    private static final Integer RANDOM_BOUND = 10;
    private static final Integer MOVE_CONDITION = 4;
    private String name;
    private Integer position;

    public Car(String name) {
        this.name = name;
        this.position = ZERO_POSITION;
    }

    public Car(String name, Integer position) {
        this.name = name;
        this.position = position;
    }

    public void updatePosition() {
        this.position += movePosition(new Movable() {
            @Override
            public boolean isMove() {
                int randomNumber = new Random().nextInt(RANDOM_BOUND);
                return randomNumber >= MOVE_CONDITION;
            }
        });
    }

    public Integer movePosition(Movable movable) {
        if (movable.isMove()) {
            return MOVE_POSITION;
        }
        return ZERO_POSITION;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(name, car.name) &&
                Objects.equals(position, car.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}