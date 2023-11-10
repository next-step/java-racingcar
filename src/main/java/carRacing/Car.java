package carRacing;


import java.util.Objects;

public class Car {
    private final Name name;
    private final MovingStrategy movingStrategy;
    private int distance = 0;

    public Car(String name, MovingStrategy movingStrategy) {
        this.name = new Name(name);
        this.movingStrategy = movingStrategy;
    }

    public void move(int number) {
        if (movingStrategy.isRide(number)) {
            distance++;
        }
    }

    public int getDistanceForPrint() {
        return distance;
    }

    public String getCarNameForPrint() {
        return name.getName();
    }

    public boolean isSameDistance(int number) {
        return number == distance;
    }

    public int findLongerDistance(int number) {
        return Math.max(number, distance);

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return distance == car.distance && Objects.equals(name, car.name) && Objects.equals(movingStrategy, car.movingStrategy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, movingStrategy, distance);
    }

    @Override
    public String toString() {
        return "Car{" + "name=" + name + ", movingStrategy=" + movingStrategy + ", distance=" + distance + '}';
    }
}
