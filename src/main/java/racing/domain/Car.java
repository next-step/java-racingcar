package racing.domain;

import racing.strategy.MoveStrategy;

public class Car {
    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public void move(MoveStrategy moveStrategy) {
        if (moveStrategy.isMoveable()) {
            this.position++;
        }
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
