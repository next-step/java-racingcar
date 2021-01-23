package racingcar.domain;

public class Car {

    private final String name;
    private int position;
    private final int GO = 4;

    public Car(String name) {
        this.name = name;
        position = 0;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move(int token) {
        if (token >= GO) {
            position++;
        }
    }
}