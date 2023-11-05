package me.namuhuchutong.step3;

public class Car {

    private int position;

    public static Car from(Car car) {
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

    public void move(RacingRule racingRule) {
        if (racingRule.isSatisfiedRule()) {
            this.position += 1;
        }
    }

    public int getPosition() {
        return position;
    }

}
