package racing.model;

import racing.strategy.CarMoveStrategy;

public abstract class Car {
    protected CarPosition position;
    private CarMoveStrategy carMoveStrategy;
    private String name;

    public Car(String name, CarPosition position) {
        this.name = name;
        this.position = position;

        setDefaultCarMoveStrategy();
    }

    public Car(String name) {
        this(name, new CarPosition());
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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Car car = (Car) obj;
        if (car.name != this.name) return false;
        return car.position.getPosition() == this.position.getPosition();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    public abstract void setDefaultCarMoveStrategy();

    public abstract String getTireMark();

    public abstract void move();

    public String getName() {
        return this.name;
    }
}
