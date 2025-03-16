package game;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;

class RandomUtilsTest {
    // 1000번 반복하여 테스트
    @RepeatedTest(value = 1000, name = "0~9사이 값만 나오는지 확인 {currentRepetition} of {totalRepetitions}")
    void random_1() {
        int randomValue = RandomUtils.nextInt(Cars.BOUND);
        Assertions.assertThat(randomValue).isBetween(0, 9);
    }
}
