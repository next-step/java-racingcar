package racing;

import MovableStrategy.MovableStrategy;

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


    public void move(MovableStrategy movableStrategy) {
        if (movableStrategy.move()) {
            position++;
        }
    }

    public boolean isPosition(int position) {
        return this.position == position;
    }
}
