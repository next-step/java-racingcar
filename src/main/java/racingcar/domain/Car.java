package racingcar.domain;


import java.util.Objects;

public class Car {

    private Position position;
    private Name name;
    private MoveStrategy moveStrategy;

    public Car(String name, MoveStrategy moveStrategy) {
        this(new Name(name), new Position(0), moveStrategy);
    }

    public Car(String name, int position, MoveStrategy moveStrategy) {
        this(new Name(name), new Position(position), moveStrategy);
    }

    public Car(Car car) {
        this(car.name, car.position, car.moveStrategy);
    }

    public Car(Name name, Position position, MoveStrategy moveStrategy) { //주 생성자
        this.name = name;
        this.position = position;
        this.moveStrategy = moveStrategy;
    }

    public void run() {
        if (moveStrategy.isMove()) {
            this.position.move();
        }
    }

    public String getName() {
        return this.name.getValue();
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
