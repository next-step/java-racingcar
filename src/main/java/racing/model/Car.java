package racing.model;

import racing.strategy.CarMoveStrategy;

public abstract class Car {
    private CarPosition position;
    private CarMoveStrategy carMoveStrategy;

    public Car(CarPosition initPosition) {
        this.position = initPosition;
        setDefaultCarMoveStrategy();
    }

    public boolean canMove(int randomNum) {
        return carMoveStrategy.canMove(randomNum);
    }

    public void setStrategy(CarMoveStrategy carMoveStrategy) {
        this.carMoveStrategy = carMoveStrategy;
    }

    public int getPosition() {
        return position.getPosition();
    }

    public void move() {
        carMoveStrategy.move(position);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Car car = (Car) obj;
        return car.position.getPosition() == this.position.getPosition();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    public abstract void setDefaultCarMoveStrategy();

    public abstract String getTireMark();
}
