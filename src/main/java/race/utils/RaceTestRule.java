package race.utils;

public class RaceTestRule implements RandomUtil {

    RandomUtil randomUtil;

    public RaceTestRule(RandomUtil randomUtil) {
        this.randomUtil = randomUtil;
    }

    public int generate() {
        return randomUtil.generate();
    }

}
