package nextstep.javaracingcar;


import java.util.function.IntSupplier;

public class GoOrStopEngine implements CarEngine {

    private final IntSupplier random;
    private final int base;

    public GoOrStopEngine(final IntSupplier random, final int base) {
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
