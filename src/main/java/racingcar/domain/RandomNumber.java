package racingcar.domain;

import java.util.Random;

public class RandomNumber {
    // random 확률 계산기
    public static int calculateRandomNumber() {
        Random random = new Random();
        int probability = random.nextInt(10);

        return probability;
    }
}
