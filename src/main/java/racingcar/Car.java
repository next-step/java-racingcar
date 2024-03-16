package racingcar;

public class Car {

    private String location;

    public Car() {
        this.location = "-";
    }

    public String getLocation() {
        return location;
    }

    public void move() {
        location += "-";
    }

}
