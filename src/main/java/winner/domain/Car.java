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
        this.name = name;
    }

    public void move(MovableStrategy moveStrategy) {
        if (moveStrategy.isMove()) {
            position.move();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return position == car.position &&
                Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
