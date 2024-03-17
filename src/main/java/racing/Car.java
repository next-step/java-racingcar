package racing;

public class Car {

    private Integer location;

    public Car(Integer location) {
        this.location = location;
    }

    public Integer getLocation() {
        return this.location;
    }

    public void moveForward() {
        this.location += 1;
    }
}
