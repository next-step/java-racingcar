package step5.domain;

import step5.utils.RandomUtil;

public class MoveCondition {

    private MoveCondition() {}

    public static int getRandomMoveCondition() {
        return RandomUtil.generateRandomNumber();
    }

}
