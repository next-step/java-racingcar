package step5;

import step5.interfaces.MoveStrategy;

public class Car implements Comparable<Car> {
    private CarLocation carLocation;
    private final CarName carName;

    public Car(String name) {
        this.carLocation = new CarLocation();
        this.carName = new CarName(name);
    }

    public CarLocation getCarLocation() {
        return this.carLocation;
    }

    public CarName getCarName() {
        return carName;
    }

    public void goOrStop(MoveStrategy moveStrategy) {
        if (moveStrategy.movable()) {
            this.carLocation = this.carLocation.progress();
        }
    }

    public boolean isWinner(CarLocation maxCarLocation) {
        return this.carLocation.equals(maxCarLocation);
    }

    @Override
    public int compareTo(Car o) {
        return Integer.compare(this.carLocation.getValue(), o.carLocation.getValue());
    }
}
