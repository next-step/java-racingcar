package step04;

import step03.strategy.MoveStrategy;
import validator.HasContentsValidator;

public class Car implements Cloneable {
    public final String name;
    private int position;
    private final MoveStrategy moveStrategy;

    private Car(String name, int position, MoveStrategy moveStrategy) {
        validateName(name);
        this.name = name;
        this.position = position;
        this.moveStrategy = moveStrategy;
    }

    public static Car of(String name, int position, MoveStrategy moveStrategy) {
        return new Car(name, position, moveStrategy);
    }

    private void validateName(String name) {
        HasContentsValidator.validate(name);
    }

    public void move() {
        if (moveStrategy.isGoing()) {
            this.position += 1;
        }
    }

    public int getPosition() {
        return this.position;
    }

    @Override
    public Car clone() throws CloneNotSupportedException {
        return (Car)super.clone();
    }

}
