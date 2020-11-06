package racing.resolver;

import utils.RandomUtils;

public class RandomAccelerateResolver implements AccelerateResolver {
    int range;
    int threshold;

    public RandomAccelerateResolver(int range, int threshold) {
        this.range = range;
        this.threshold = threshold;
    }

    @Override
    public boolean resolve() {
        return RandomUtils.nextInt(range) >= threshold;
    }
}
