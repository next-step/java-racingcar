package study.racingcar;

public class Car {
    private String name;
    private int position;

    public Car(String name) {
        this.name = name;
        position = 0;
    }

    public void addPosition(int distance) {
        position += distance;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
