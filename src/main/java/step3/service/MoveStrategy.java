package step3.service;

import java.util.Random;


public class MoveStrategy {
    Random random = new Random();
    private final Integer maxRandomNum = 10;
    private final Integer moveCondition = 4;

    public Integer generateRandomNumber() {
        return random.nextInt(maxRandomNum);
    }

    public Boolean getIsMove(Integer moveNum) {
        return moveNum >= moveCondition ? true : false;
    }
}
