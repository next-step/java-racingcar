package winner.domain;

import java.util.Objects;

/**
 * @author : 김윤호
 * @version : 1.0
 * @date : 2019-11-01 14:03
 */
public class Car {

    private final String name;
    private CarPosition position;

    public Car(String name) {
        this(name, 0);
    }

    public Car(String name, int position) {
        this.name = name;
        this.position = new CarPosition(position);
    }

    public String getName() {
        return name;
    }

    public void move(MovableStrategy moveStrategy) {
        if (moveStrategy.isMove()) {
            position.move();
        }
    }

    public String getCurrentPositionText() {
        return String.format("%s : %s", name, position.toText());
    }

    public boolean isMaxPosition(int maxPosition) {
        return this.position.isMax(maxPosition);
    }

    public int getCurrentPosition() {
        return position.getCurrentPosition();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(name, car.name) &&
                Objects.equals(position, car.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
