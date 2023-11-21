package racingCar.domain;

public class Car {
    private final CarName name;
    private Distance distance;

    private Car(CarName name, Distance distance) {
        this.name = name;
        this.distance = distance;
    }

    public static Car from(String name) {
        return new Car(CarName.from(name), Distance.init());
    }

    public void move() {
        distance.increase();
    }

    public boolean isSameDistance(int otherDistance) {
        return distance.isSameDistance(otherDistance);
    }

    public String getName() {
        return name.getName();
    }

    public int getDistance() {
        return distance.getDistance();
    }
}
