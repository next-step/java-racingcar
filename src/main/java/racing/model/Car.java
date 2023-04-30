package racing.model;

import racing.model.move.MoveStrategy;
import racing.util.RandomUtil;

public class Car implements Comparable<Car> {

    private Name name;
    private Position position;
    private MoveStrategy moveStrategy;

    public Car(String name, MoveStrategy moveStrategy) {
        this.name = new Name(name);
        this.position = new Position();
        this.moveStrategy = moveStrategy;
    }

    public Car(String name, int position, MoveStrategy moveStrategy) {
        this.name = new Name(name);
        this.position = new Position(position);
        this.moveStrategy = moveStrategy;
    }

    public void move() {
        if (moveStrategy.move()) {
            position.move();
        }
    }

    public int getPosition() {
        return position.getPosition();
    }

    public String getName() {
        return name.getName();
    }

    public boolean isSamePosition(int position) {
        return this.position.getPosition() == position;
    }

    @Override
    public int compareTo(Car car) {
        return (this.position.getPosition() > car.getPosition()) ? 1 : -1;
    }
}
