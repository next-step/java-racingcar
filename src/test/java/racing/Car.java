package racing;

public class Car {
    private int distance = 1;

    private Car() {
    }

    public static Car defaultOf() {
        return new Car();
    }
}
