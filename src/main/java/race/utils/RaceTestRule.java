package race.utils;

import race.utils.RandomUtil;

public class RaceTestRule implements RandomUtil {

    RandomUtil randomUtil;

    public RaceTestRule(RandomUtil randomUtil) {
        this.randomUtil = randomUtil;
    }

    public int generate() {
        return randomUtil.generate();
    }

}
