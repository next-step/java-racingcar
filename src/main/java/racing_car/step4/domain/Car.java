package racing_car.step4.domain;

import racing_car.step4.dto.CarDTO;

import java.util.Objects;

public class Car {
    private final Position position;
    private final CarName carName;
    
    public Car(CarName carName) {
        this(carName, new Position(0));
    }
    
    public Car(CarName carName, Position position) {
        this.position = position;
        this.carName = carName;
    }
    
    public boolean isWinner(int maxPosition) {
        return position.equals(new Position(maxPosition));
    }
    
    public Car moveTry(MoveStrategy moveStrategy) {
        if (moveStrategy.isMove()) {
            return new Car(carName, position.increase());
        }
        return this;
    }
    
    public CarDTO information() {
        return new CarDTO(carName, position);
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(position, car.position) && Objects.equals(carName, car.carName);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(position, carName);
    }
}
