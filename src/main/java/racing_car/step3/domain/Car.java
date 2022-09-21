package racing_car.step3.domain;

import racing_car.step3.dto.CarDTO;

import java.util.Objects;

public class Car {
    private int position;
    
    public Car(int position) {
        this.position = position;
    }
    
    public void move(MoveStrategy moveStrategy) {
        if (moveStrategy.isMove()) {
            position++;
        }
    }
    
    public CarDTO information() {
        return new CarDTO(position);
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
