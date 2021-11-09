package step3.utils;

import org.junit.jupiter.api.RepeatedTest;

import static org.assertj.core.api.Assertions.assertThat;

class RandomUtilsTest {

    @RepeatedTest(value = 10)
    void 범위_0_9_사이의_랜덤_숫자를_생성한다() {
        //given
        int number = RandomUtils.nextInt();
        //when & then
        assertThat(number).isGreaterThanOrEqualTo(0).isLessThanOrEqualTo(9);
    }

}