package racingcar;

public class Car {

    private String name;
    private int position;

    Car(String name) {
        this.name = name;
    }

    public void move() {
        position++;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
