package step5.domain;

import step5.common.PositionToDash;
import step5.domain.strategy.MoveStrategy;

public class Car implements Comparable<Car> {
    public static final int INIT_POSITION = 0;
    private String name;
    private int position;

    private Car(String name) {
        validation(name);
        this.name = name;
        this.position = INIT_POSITION;
    }

    private Car(String name, int position) {
        validation(name);
        this.name = name;
        this.position = position;
    }


    public static Car from(String name) {
        return new Car(name);
    }

    public static Car of(String name, int position) {
        return new Car(name, position);
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return name + " : " + PositionToDash.makeDash(position);
    }

    @Override
    public int compareTo(Car other) {
        if (this.getPosition() > other.getPosition()) {
            return 1;
        }
        if (this.getPosition() == other.getPosition()) {
            return 0;
        }
        return -1;
    }

    private void validation(String name) {
        if (name.length() > 5) {
            throw new IllegalStateException("이름은 5글자 이하로 설정해야 합니다.");
        }
    }

    public void move(MoveStrategy strategy) {
        if (isMove) {
            this.position++;
        }
    }
}
