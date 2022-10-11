package nextstep.javaracingcar;


import java.util.function.IntSupplier;

public class RandomGoOrStop implements MovingStrategy {

    private final IntSupplier random;
    private final int base;

    public RandomGoOrStop(final IntSupplier random, final int base) {
        this.random = random;
        this.base = base;
    }

    @Override
    public Distance move() {
        if (random.getAsInt() >= base) {
            return Distance.ONE;
        }

        return Distance.ZERO;
    }
}
