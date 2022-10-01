package step4.util;

import step3.util.numberGenerator.NumberGenerator;

public class FixedNumberGenerator implements NumberGenerator {
    @Override
    public int generate(int number) {
        return number;
    }
}
