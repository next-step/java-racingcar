package racing.resolver;

import utils.RandomUtils;

public class RandomAccelerateResolver implements AccelerateResolver {
    private final int range;
    private final int threshold;

    public RandomAccelerateResolver(int range, int threshold) {
        this.range = range;
        this.threshold = threshold;
    }

    @Override
    public boolean resolve() {
        return RandomUtils.nextInt(range) >= threshold;
    }
}
