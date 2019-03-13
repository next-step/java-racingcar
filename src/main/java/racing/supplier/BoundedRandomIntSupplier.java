package racing.supplier;

import java.util.Random;
import java.util.function.IntSupplier;

public class BoundedRandomIntSupplier implements IntSupplier {

    private Random random;

    private int bound;

    public BoundedRandomIntSupplier(int bound) {
        random = new Random();
        this.bound = bound;
    }

    @Override
    public int getAsInt() {
        return random.nextInt(bound);
    }
}
