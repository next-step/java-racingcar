package racingcar;

import java.util.Objects;

public class Car {

    private Position position;

    public Car() {
        this.position = new Position(0);
    }

    public Car(Car car) {
        this.position = new Position(car.position);
    }

    /* 테스트용 생성자 */
    protected Car(int position) {
        this.position = new Position(position);
    }

    public void move(MoveStrategy moveStrategy) {
        if (moveStrategy.movable()) {
            position = position.increase();
        }
    }

    int getCarPosition() {
        return position.getPosition();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(position, car.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
