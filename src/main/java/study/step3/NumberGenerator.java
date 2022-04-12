package study.step3;

import java.util.Random;

/**
 * 랜덤값 생성기
 */
public class NumberGenerator {
    public static int randomVal(int maxValue) {
        Random random = new Random();

        int num = random.nextInt(maxValue);
        if(num > 9) {
            throw new IllegalArgumentException("Please change the maxValue");
        }

        return num;
    }
}
