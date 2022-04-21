package racing.domain;

import MovableStrategy.MovingStrategy;

public class Car {
    private final String name;
    private int position;

    public Car(String name) {
        this(name, 0);
    }

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }


    public void move(MovingStrategy movingStrategy) {
        if (movingStrategy.movable()) {
            position++;
        }
    }

    public boolean isPosition(int position) {
        return this.position == position;
    }
}
