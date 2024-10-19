package racingcar.domain;


import java.util.Objects;

public class Car {

    private static final int NAME_MAX_LENGTH = 5;
    private Position position;
    private String name;
    private MoveStrategy moveStrategy;

    public Car(String name, MoveStrategy moveStrategy) {
        validateName(name);
        this.name = name;
        this.position = new Position(0);
        this.moveStrategy = moveStrategy;
    }

    public Car(String name, Position position, MoveStrategy moveStrategy) {
        validateName(name);
        this.name = name;
        this.position = position;
        this.moveStrategy = moveStrategy;
    }

    public Car(Car car){
        this.position = car.position;
        this.name = car.name;
        this.moveStrategy = car.moveStrategy;
    }

    private void validateName(String name) {
        if (name.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("자동차의 이름은 5자를 초과할 수 없다.");
        }
    }

    public String getName() {
        return this.name;
    }

    public void run() {
        if (moveStrategy.isMove()) {
            this.position.move();
        }
    }

    public String getStatus(String symbol){
        return this.position.getStatus(symbol);
    }

    public boolean comparePosition(int position) {
        return this.position.comparePosition(position);
    }

    public int getMaxPosition(int prevPosition){
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
