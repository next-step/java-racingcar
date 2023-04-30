package racing.model;

import racing.model.move.MoveStrategy;
import racing.util.RandomUtil;

public class Car implements Comparable<Car> {

    private String name;
    private Position position;

    public Car() {
        this.position = new Position();
    }

    public Car(String name) {
        this.name = name;
        this.position = new Position();
    }

    public Car(String name, int position) {
        this.name = name;
        this.position = new Position(position);
    }

    public void move(MoveStrategy moveStrategy) {
        if (moveStrategy.move()) {
            position.move();
        }
    }

    public int getPosition() {
        return position.getPosition();
    }

    public String getName() {
        return name;
    }

    public boolean isSamePosition(int position) {
        return this.position.getPosition() == position;
    }

    @Override
    public int compareTo(Car car) {
        return (this.position.getPosition() > car.getPosition()) ? 1 : -1;
    }
}
