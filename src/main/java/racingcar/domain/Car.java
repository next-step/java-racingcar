package racingcar.domain;

import racingcar.utils.MovingStrategy;

import java.util.Objects;

public class Car {
    private CarName name;
    private CarPosition position;

    public Car(String name) {
        this.name = new CarName(name);
        position = new CarPosition();
    }

    public void move(MovingStrategy movingStrategy) {
        if(movingStrategy.isMoving()){
            this.position.addOne();
        }
    }

    public CarPosition getPosition() {
        return position;
    }

    public String getName() {
        return this.name.getName();
    }

    public boolean isMoreThan(CarPosition tempWinnerPosition){
        return this.position.isMoreThan(tempWinnerPosition);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return name.equals(car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
