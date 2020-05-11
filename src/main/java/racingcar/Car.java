package racingcar;

import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

public class Car {
    private static final int DEFAULT_POSITION = 0;

    private int position;
    private String name;
    private MovableStrategy movableStrategy;

    private Car(int position, String name, MovableStrategy movableStrategy) {
        this.position = position;
        this.name = name;
        this.movableStrategy = movableStrategy;
    }

    public static Car newInstance(String name) {
        if (StringUtils.isEmpty(name)) {
            throw new IllegalArgumentException("이름이 비어있습니다.");
        }
        return new Car(DEFAULT_POSITION, name, new RandomMovableStrategy());
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MovableStrategy getMovableStrategy() {
        return movableStrategy;
    }

    public void setMovableStrategy(MovableStrategy movableStrategy) {
        this.movableStrategy = movableStrategy;
    }

    public int move() {
        validate();
        this.position += movableStrategy.move();
        return position;
    }

    private void validate() {
        if (position < DEFAULT_POSITION || Objects.isNull(movableStrategy)) {
            throw new IllegalArgumentException();
        }
    }
}
