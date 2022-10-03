package test.racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.RandomUtil;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class RandomUtilTest {

    @Test
    @DisplayName("음수 불가")
    void randomUtilTest1() {
        assertThrows(RuntimeException.class, () -> {
            new RandomUtil().isBiggerThan(-1);
        });
    }

    @Test
    @DisplayName("9 이상 불가")
    void randomUtilTest2() {
        assertThrows(RuntimeException.class, () -> {
            new RandomUtil().isBiggerThan(10);
        });
    }

    // todo : 난수 테스트
}
