package racingCar.domain;

public class Car {

    private final Distance distance;
    private final Name name;

    public Car(Name name) {
        this.name = name;
        this.distance = new Distance();
    }

    public Car(Name name, Distance distance) {
        this.name = name;
        this.distance = distance;
    }

    public Car move(boolean command) {
        if(command) {
            return new Car(this.name, this.distance.addDistance());
        }
        return this;
    }

    public String getCarName() {
        return name.getName();
    }

    public int getCarDistance() {
        return distance.getDistance();
    }

}
