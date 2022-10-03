package racingcar;

import java.util.Random;

public class RandomUtil {

    public static final int MAX_NUM = 9;

    public boolean isBiggerThan(int num) {
        validate(num);
        return new Random().nextInt(10) >= num;
    }

    private void validate(int num) throws RuntimeException {
        if (num < 0) {
            throw new RuntimeException("음수는 올 수 없습니다.");
        }

        if (num > MAX_NUM) {
            throw new RuntimeException("숫자는 최대 9을 초과할 수 없습니다.");
        }
    }
}
