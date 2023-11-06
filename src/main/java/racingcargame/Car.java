package racingcargame;

public class Car {

    private String location;

    public Car(String location) {
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    public void move() {
        this.location += "-";
    }
}
