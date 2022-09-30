package racingcar.domain;

import static racingcar.domain.Moving.*;

public class Car {
    private Distance total;

    public Car() {
        total = Distance.ZERO;
    }

    public Distance move(Moving moving) {
        if (moving == GO) {
            total = total.increment();
        }
        return total;
    }
}
