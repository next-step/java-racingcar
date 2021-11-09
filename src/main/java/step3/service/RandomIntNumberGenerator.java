package step3.service;

import step3.utils.RandomUtils;

public class RandomIntNumberGenerator implements IntNumberGenerator {

    @Override
    public int generate() {
        return RandomUtils.nextInt();
    }
}
