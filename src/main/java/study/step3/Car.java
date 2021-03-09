package study.step3;

public class Car {

    private int location;

    private Car() {
        this.location = 0;
    }

    public int getLocation() {
        return location;
    }

    public static Car of() {
        return new Car();
    }
}
