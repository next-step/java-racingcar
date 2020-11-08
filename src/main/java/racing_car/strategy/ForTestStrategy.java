package racing_car.strategy;

import java.util.function.BooleanSupplier;

public class ForTestStrategy implements MoveStrategy {

    private final BooleanSupplier booleanSupplier;

    public ForTestStrategy(BooleanSupplier booleanSupplier) {
        this.booleanSupplier = booleanSupplier;
    }

    @Override
    public boolean move() {
        return this.booleanSupplier.getAsBoolean();
    }
}
