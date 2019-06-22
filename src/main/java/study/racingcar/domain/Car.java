package study.racingcar.domain;

import study.racingcar.strategy.MovableStrategy;
import study.racingcar.strategy.RandomMovableStrategy;

import java.util.Objects;

/**
 * Created by wyparks2@gmail.com on 2019-06-17
 * Blog : http://wyparks2.github.io
 * Github : http://github.com/wyparks2
 */
public class Car {
    private MovableStrategy movableStrategy;
    private String name;
    private int position = 1;

    public Car(String name) {
        this.name = name;
        this.movableStrategy = new RandomMovableStrategy();
    }

    public Car(String name, MovableStrategy movableStrategy) {
        this.name = name;
        this.movableStrategy = movableStrategy;
    }

    public int run() {
        if (this.canMove()) {
            position++;
        }

        return position;
    }

    private boolean canMove() {
        return movableStrategy.canMove();
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
