package step03Refactor;

import java.util.Objects;

public class Car {
    private Position position;
    private Name name;

    public Car(String name) {
        this.name = new Name(name);
        this.position = new Position();
    }

    public Car(String name, int position) {
        this.name = new Name(name);
        this.position = new Position(position);
    }

    public void move(MoveStrategy moveStrategy) {
        if (moveStrategy.isMove()) {
            position.increase();
        }
    }

    public boolean isWinnerPosition(int maxPosition) {
        return position.isBiggerPosition(maxPosition);
    }

    public boolean isWinner(int maPosition) {
        return position.isSamePosition(maPosition);
    }

    public int getCarPosition() {
        return position.getPosition();
    }

    public String getCarName() {
        return name.getName();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return position.equals(car.position) &&
                name.equals(car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, name);
    }

}
