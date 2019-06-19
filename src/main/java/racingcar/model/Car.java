package racingcar.model;

public class Car {
    private int position;

    public Car(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public Car move(int position) {
        this.setPosition(position);
        return this;
    }
}

