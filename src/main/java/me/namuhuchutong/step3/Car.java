package me.namuhuchutong.step3;

public class Car {

    private int position;
    private final RacingRule racingRule;

    public static Car from(Car car) {
        return new Car(car.getRacingRule(), car.getPosition());
    }

    public Car(RacingRule racingRule, int position) {
        validateCarPosition(position);
        this.position = position;
        this.racingRule = racingRule;
    }

    private void validateCarPosition(int position) {
        if (position < 0) {
            throw new IllegalArgumentException("자동차 위치는 음수일 수 없습니다. - " + position);
        }
    }

    public void move() {
        if (racingRule.isSatisfiedRule()) {
            this.position += 1;
        }
    }

    public int getPosition() {
        return position;
    }

    public RacingRule getRacingRule() {
        return racingRule;
    }
}
