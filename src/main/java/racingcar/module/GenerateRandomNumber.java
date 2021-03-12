package racingcar.module;

import racingcar.Constant;

import java.util.Random;

public class GenerateRandomNumber {
    private Random randomNum;

    public GenerateRandomNumber() {
        this.randomNum = new Random();
    }

    public int getRandomNum() {
        return randomNum.nextInt(Constant.MAX_RANDOM_NUM);
    }
}
