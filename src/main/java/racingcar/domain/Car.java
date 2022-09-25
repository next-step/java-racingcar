package racingcar.domain;

public class Car {
    private Distance total;

    public Car() {
        total = Distance.ZERO;
    }

    public Distance move(MovingFlag flag) {
        if (flag.canMove()) {
            total = total.increment();
        }
        return total;
    }
}
