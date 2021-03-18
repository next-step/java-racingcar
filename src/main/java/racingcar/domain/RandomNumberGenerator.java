package racingcar.domain;

import racingcar.Constant;

import java.util.Random;

public class RandomNumberGenerator {
    private Random randomNum;

    public RandomNumberGenerator() {
        this.randomNum = new Random();
    }

    public int getRandomNum() {
        return randomNum.nextInt(Constant.MAX_RANDOM_NUM);
    }
}
