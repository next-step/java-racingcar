package race;

public class RaceRule implements RandomUtil {

    RandomUtil randomUtil;

    public RaceRule(RandomUtil randomUtil) {
        this.randomUtil = randomUtil;
    }

    public int generate() {
        return randomUtil.generate();
    }

}
