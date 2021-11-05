package racingcar.service.domain;

import racingcar.service.strategy.RoundRule;
import racingcar.utils.Preconditions;

public class Car implements Cloneable {
    private static final Integer INIT_POSITION = 0;

    private final String name;
    private Integer position;

    public Car(String name) {
        Preconditions.checkString(name, "name은 필수값입니다.");

        this.name = name;
        this.position = INIT_POSITION;
    }

    public void race(RoundRule roundRule) {
        if (roundRule.checkCondition())
            position++;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public Car clone() {
        try {
            return (Car) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}