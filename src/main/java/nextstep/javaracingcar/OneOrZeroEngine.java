package nextstep.javaracingcar;


import java.util.function.IntSupplier;

public class OneOrZeroEngine implements CarEngine {

    private final IntSupplier random;
    private final int base;

    public OneOrZeroEngine(final IntSupplier random, final int base) {
        this.random = random;
        this.base = base;
    }

    @Override
    public Distance work() {
        if (random.getAsInt() >= base) {
            return Distance.ONE;
        }

        return Distance.ZERO;
    }
}
