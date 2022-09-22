package racing_car.step3.domain;

import racing_car.step3.dto.CarDTO;

import java.util.Objects;

public class Car {
    private final Position position;
    
    public Car(Position position) {
        this.position = position;
    }
    
    public Car moveTry(MoveStrategy moveStrategy) {
        if (moveStrategy.isMove()) {
            return new Car(position.increase());
        }
        return this;
    }
    
    public CarDTO information() {
        return new CarDTO(position);
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
