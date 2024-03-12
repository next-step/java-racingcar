package race;

public class RaceRule {

    RandomUtil randomUtil;

    public RaceRule(RandomUtil randomUtil) {
        this.randomUtil = randomUtil;
    }

    public int generate() {
        return randomUtil.generate();
    }

}
