package carracing.domain;

import carracing.util.RandomUtil;

public class RandomNumberGenerator implements NumberGenerator{
    @Override
    public int generate() {
        return RandomUtil.getRandomValue();
    }
}
