package racingcar;

public class Car {

    private int position = 0;
    private String name;

    public Car() {
        this("unknown");
    }

    public Car(String name) {
        this.name = name;
    }

    public void move() {
        position++;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
