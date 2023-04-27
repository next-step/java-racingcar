package domain;

import java.util.Objects;

public class Car {
    private final CarName carName;
    private CarPosition position;

    public Car(String name) {
        this(name,0);
    }

    public Car(String name, int position) {
        this.carName = new CarName(name);
        this.position = new CarPosition(position);
    }

    public void move(int randomNumber) {
        if(RacingRule.moveOrStop(randomNumber)){
            position = position.move();
        }
    }

    public String getName() {
        return carName.getName();
    }
    public CarPosition getPosition() {
        return position;
    }
    public int getPositionValue() {
        return position.getValue();
    }
    public boolean isOnlyWinner(CarPosition maxPosition) {
        return position.isBiggerThan(maxPosition);
    }
    public boolean isSharedWinner(CarPosition maxPosition) {
        return position.isEqualThan(maxPosition);
    }

    @Override
    public boolean equals(Object ob) {
        if (this == ob) return true;
        if (ob == null || getClass() != ob.getClass()) return false;
        Car car = (Car) ob;
        return Objects.equals(carName, car.carName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName);
    }
}