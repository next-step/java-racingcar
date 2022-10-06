package racingcar;

public class Car {
    private int position = 0;
    private String name;

    public Car() {}

    public Car(String name) {
        this.name = name;
    }

    public void forward() {
        position += 1;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
