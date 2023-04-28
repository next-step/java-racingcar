package racing.model;

import racing.model.move.MoveStrategy;
import racing.util.RandomUtil;

public class Car {

    private String name;
    private int position;

    public Car() {
    }

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public void move(MoveStrategy moveStrategy) {
        if (moveStrategy.move()) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
