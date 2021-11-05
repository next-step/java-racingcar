package step3.domain.power;

import static step3.utils.ValidationUtils.checkPositive;

public class StaticPower implements Power {

    private final int power;

    public StaticPower(Integer power) {
        checkPositive(power, "power is required;");
        this.power = power;
    }

    @Override
    public int generatePower() {
        return power;
    }
}
