package racinggame.model.car;

import java.util.Objects;
import racinggame.model.move.MoveStrategy;
import racinggame.model.position.Position;

public class Car {
    private static final String RACE_STATE_PER_CAR_DELIMITER = " : ";

    private Position position;
    private CarName name;

    public Car(String name) {
        this.position = new Position();
        this.name = new CarName(name);
    }

    public void move(MoveStrategy moveStrategy) {
        if (moveStrategy.moveable()) {
            this.position.plus();
        }
    }

    public boolean isSamePosition(Position checkPosition) {
        return this.position.equals(checkPosition);
    }

    public boolean hasDownPosition(Position checkPosition) {
        return this.position.hasDownPosition(checkPosition);
    }

    public Position compareAndChangeIfMax(Position maxPosition) {
        if (hasDownPosition(maxPosition) || isSamePosition(maxPosition)) {
            return maxPosition;
        }
        
        return this.position;
    }

    public String getStateMessage() {
        return this.name
                + RACE_STATE_PER_CAR_DELIMITER
                + this.position.getStateMessage();
    }

    public CarName name() {
        return this.name;
    }
    
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Car car = (Car) o;
        return Objects.equals(position, car.position)
                && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, name);
    }
}
