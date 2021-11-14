package study.racing.model.rule;

import study.racing.utils.RandomUtils;

public class RandcomNumberRule implements Rule {

    private static final int CRITERIA = 4;
    private static final int LIMIT_RANGE = 10;

    @Override
    public boolean isFollowRule() {
        return RandomUtils.nextInt(LIMIT_RANGE) > CRITERIA;
    }
}
