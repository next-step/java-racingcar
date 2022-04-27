package racingCar.domains;

import racingCar.interfaces.NumberGeneratorStrategy;

public class FixedNumberGenerator implements NumberGeneratorStrategy {
    private int number;

    public FixedNumberGenerator(int number) {
        this.number = number;
    }
    public int generate() {
        return this.number;
    }
}
