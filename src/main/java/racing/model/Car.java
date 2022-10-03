package racing.model;

import racing.strategy.GoStraightStrategy;

import java.util.Objects;

public class Car implements Comparable<Car> {

    private CurrentLocation currentLocation;

    private Name name;

    public Car(int startLocation, String name) {
        this(new Name(name), new CurrentLocation(startLocation));
    }

    public Car(Name name, CurrentLocation startLocation) {
        this.name = name;
        this.currentLocation = startLocation;
    }

    public String getName() {
        return name.getName();
    }

    public int getCurrentLocation() {
        return currentLocation.getCurrentLocation();
    }

    public void goStraight(GoStraightStrategy goStraightStrategy) {
        if (goStraightStrategy.isGoStraight()) {
            this.currentLocation = this.currentLocation.goStraight();
        }
    }

    public boolean isSameCurrentLocation(Car comparisonCar) {
        return currentLocation.equals(comparisonCar.currentLocation);
    }

    @Override
    public int compareTo(Car o) {
        return currentLocation.compareTo(o.currentLocation);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return Objects.equals(getCurrentLocation(), car.getCurrentLocation()) && Objects.equals(getName(), car.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCurrentLocation(), getName());
    }
}
