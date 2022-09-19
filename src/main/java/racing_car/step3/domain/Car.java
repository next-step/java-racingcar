package racing_car.step3.domain;

import java.util.Objects;

public class Car {
    private int position;
    
    public Car() {
    }
    
    public Car(int position) {
        this.position = position;
    }
    
    public void move(MoveStrategy moveStrategy) {
        if (moveStrategy.isMove()) {
            position++;
        }
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return position == car.position;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
