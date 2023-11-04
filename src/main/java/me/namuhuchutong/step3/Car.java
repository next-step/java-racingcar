package me.namuhuchutong.step3;

public class Car {

    public static final String MARKER = "-";

    private int position;


    public static Car newInstance(Car car) {
        return new Car(car.getPosition());
    }

    private Car(int position) {
        this.position = position;
    }

    public Car() {
        this.position = 0;
    }

    public void move(boolean moveCondition) {
        if (moveCondition) {
            this.position += 1;
        }
    }

    public int getPosition() {
        return position;
    }

    public String getPositionToString() {
        return MARKER.repeat(this.position);
    }
}
