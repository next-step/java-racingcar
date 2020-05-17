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

    public int getPosition() {
        return position;
    }
}
