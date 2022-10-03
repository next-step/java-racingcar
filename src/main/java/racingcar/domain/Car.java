package racingcar.domain;

import static racingcar.domain.Moving.*;

public class Car {
    private Distance total;

    public Car(String name) {
        total = new Distance(name);
    }

    public Distance move(Moving moving) {
        if (moving == GO) {
            total = total.increment();
        }
        return total;
    }
}
