package study.racingcar;

public class Car {

    private String name;
    private int position;

    public Car(int position, String name) {
        this.position = position;
        this.name = name;
    }

    public int currentPosition() {
        return this.position;
    }

    public void move(int position) {
        this.position = position + 1;
    }

    public String getName() {
        return this.name;
    }

    public boolean isPosition(int maxPosition) {

        return this.position == maxPosition;
    }
}
