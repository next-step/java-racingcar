package racing_car.step4.domain;

import racing_car.step4.dto.CarDTO;

import java.util.Objects;

public class Car {
    private final Position position;
    private final Name name;
    
    public Car(Name name) {
        this(name, new Position(0));
    }
    
    public Car(Name name, Position position) {
        this.position = position;
        this.name = name;
    }
    
    public boolean isWinner(int maxPosition) {
        return position.isSame(maxPosition);
    }
    
    public Car moveTry(MoveStrategy moveStrategy) {
        if (moveStrategy.isMove()) {
            return new Car(name, position.increase());
        }
        return this;
    }
    
    public CarDTO information() {
        return new CarDTO(name, position);
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
