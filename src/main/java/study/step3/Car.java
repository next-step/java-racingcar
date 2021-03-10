package study.step3;

public class Car {

    private int location;

    private Car() {
        this.location = 0;
    }

    public static Car of() {
        return new Car();
    }

    public int getLocation() {
        return location;
    }

    public Car move() {
        location++;
        return this;
    }
}
