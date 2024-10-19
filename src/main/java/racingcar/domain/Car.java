package racingcar.domain;


import java.util.Objects;

public class Car {

    private Position position;
    private Name name;
    private MoveStrategy moveStrategy;

    public Car(String name, MoveStrategy moveStrategy) {
        this.name = new Name(name);
        this.position = new Position(0);
        this.moveStrategy = moveStrategy;
    }

    public Car(String name, Position position, MoveStrategy moveStrategy) {
        this.name = new Name(name);
        this.position = position;
        this.moveStrategy = moveStrategy;
    }

    public Car(Car car) {
        this.position = car.position;
        this.name = car.name;
        this.moveStrategy = car.moveStrategy;
    }

    public String getName() {
        return this.name.getName();
    }

    public void run() {
        if (moveStrategy.isMove()) {
            this.position.move();
        }
    }

    public String getStatus(String symbol) {
        return this.position.getStatus(symbol);
    }

    public boolean comparePosition(int position) {
        return this.position.comparePosition(position);
    }

    public int getMaxPosition(int prevPosition) {
        return this.position.getMaxPosition(prevPosition);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(position, car.position) && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, name);
    }
}
