package step3.domain.car;

import step3.domain.power.Power;

public class StaticPower implements Power {

    private static final int MIN_POSITIVE_VALUE = 0;
    private final int power;

    public StaticPower(Integer power) {
        if (power == null || power <= MIN_POSITIVE_VALUE) {
            throw new IllegalArgumentException("power is required;");
        }
        this.power = power;
    }

    @Override
    public int generatePower() {
        return power;
    }
}
