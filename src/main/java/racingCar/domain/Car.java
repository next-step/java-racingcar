package racingCar.domain;

public class Car {
    private final CarName name;
    private Distance distance;

    public Car(CarName name, Distance distance) {
        this.name = name;
        this.distance = distance;
    }

    public static Car from(String name) {
        return new Car(CarName.from(name), Distance.init());
    }

    public void move(boolean isMovable) {
        if (isMovable) {
            distance.increase();
        }
    }

    public String getName() {
        return name.getName();
    }

    public int getDistance() {
        return distance.getDistance();
    }
}
