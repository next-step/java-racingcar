package nextstep.javaracingcar;

import nextstep.javaracingcar.step2.PositiveNumber;

import java.util.function.IntSupplier;

public class OneOrZeroEngine implements CarEngine {

    private final IntSupplier random;
    private final int base;

    public OneOrZeroEngine(final IntSupplier random, final int base) {
        this.random = random;
        this.base = base;
    }

    @Override
    public PositiveNumber work() {
        if (random.getAsInt() >= base) {
            return PositiveNumber.ONE;
        }

        return PositiveNumber.ZERO;
    }
}
