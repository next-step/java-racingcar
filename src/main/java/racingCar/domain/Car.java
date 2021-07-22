package racingCar.domain;

public class Car {

    private final Distance distance;

    public Car() {
        this.distance = new Distance();
    }

    public Car(Distance distance) {
        this.distance = distance;
    }

    public Car move(boolean command) {
        if(command) {
            return new Car(this.distance.addDistance());
        }
        return this;
    }

    public int getCarDistance() {
        return distance.getDistance();
    }

}
