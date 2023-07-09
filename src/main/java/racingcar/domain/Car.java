package racingcar.domain;

import racingcar.domain.movable.Movable;

public class Car {

    private final CarName name;
    private final Distance distance;

    public Car(String name, int distance) {
        this.name = new CarName(name);
        this.distance = new Distance(distance);
    }

    public Car(String name) {
        this(name, 0);
    }

    public void progress(Movable movable) {
        if (movable.canMove()) {
            distance.increase();
        }
    }

    public boolean isSameDistance(int maxDistance) {
        return this.distance.isSameDistance(maxDistance);
    }

    public boolean isSameDistance(Car car) {
        return this.distance.isSameDistance(car.distance);
    }

    public Car returnFurtherMovedCar(Car car) {
        if (this.distance.isGreaterThan(car.distance)) {
            return this;
        }
        
        return car;
    }

    public String getName() {
        return name.getCarName();
    }

    public int getDistance() {
        return distance.getDistance();
    }
}
