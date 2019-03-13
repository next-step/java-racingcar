package racing.supplier;

import java.util.Random;
import java.util.function.IntSupplier;

public class BoundedIntSupplier implements IntSupplier {

    private Random random;

    private int bound;

    public BoundedIntSupplier(int bound) {
        random = new Random();
        this.bound = bound;
    }

    @Override
    public int getAsInt() {
        return random.nextInt(bound);
    }
}
