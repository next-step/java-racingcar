package racing.generator;

import java.util.Random;

public class BoundedIntSupplier implements IntSupplier {

    private Random random;

    private int bound;

    public BoundedIntSupplier(int bound) {
        random = new Random();
        this.bound = bound;
    }

    @Override
    public int nextInt() {
        return random.nextInt(bound);
    }
}
