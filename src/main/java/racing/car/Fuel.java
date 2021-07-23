package racing.car;

import util.RandomUtils;

import java.util.function.BooleanSupplier;

public enum Fuel {
    EMPTY(() -> false),
    MIN(() -> true,
            4),
    FULL(() -> true,
            9),
    RANDOM(() -> RandomUtils.nextInt(FULL.value) >= MIN.value);

    Fuel(BooleanSupplier funcMovable, int value) {
        this.funcMovable = funcMovable;
        this.value = value;
    }

    Fuel(BooleanSupplier funcMovable) {
        this(funcMovable, 0);
    }

    private final BooleanSupplier funcMovable;

    private final int value;


    public boolean isMovable() {
        return funcMovable.getAsBoolean();
    }
}
