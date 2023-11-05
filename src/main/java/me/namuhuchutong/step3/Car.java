package me.namuhuchutong.step3;

public class Car {

    public static final String MARKER = "-";

    private int position;


    public static Car newInstance(Car car) {
        return new Car(car.getPosition());
    }

    public Car() {
        this(0);
    }

    public Car(int position) {
        validateCarPosition(position);
        this.position = position;
    }

    private void validateCarPosition(int position) {
        if (position < 0) {
            throw new IllegalArgumentException("자동차 위치는 음수일 수 없습니다. - " + position);
        }
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
