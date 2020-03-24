package racingcar.domain;

public class Car {

    private String name;
    private int position;

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move(int distance) {
        this.position = this.position + distance;
    }

    public Car clone() {
        return new Car(this.name, this.position);
    }
}
