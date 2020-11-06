package racing.resolver;

import java.util.function.BooleanSupplier;

public class SupplierAccelerateResolver implements AccelerateResolver {
    private final BooleanSupplier supplier;

    public SupplierAccelerateResolver(BooleanSupplier supplier) {
        this.supplier = supplier;
    }

    @Override
    public boolean resolve() {
        return supplier.getAsBoolean();
    }
}
