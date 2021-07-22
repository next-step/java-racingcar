package racing.car;

import util.RandomUtils;

import java.util.function.BooleanSupplier;

public enum Fuel {
    EMPTY(() ->
            false),
    RANDOM(() ->
            RandomUtils.nextBoolean(9, 4)),
    FULL(() ->
            true);

    Fuel(BooleanSupplier funcMovable) {
        this.funcMovable = funcMovable;
    }

    private final BooleanSupplier funcMovable;

    public boolean isMovable() {
        return funcMovable.getAsBoolean();
    }
}
