package racingCar;

public class Car {
    private final String name;
    private int position;

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void go() {
        position += 1;
    }

    public int getPosition() {
        return position;
    }
}
