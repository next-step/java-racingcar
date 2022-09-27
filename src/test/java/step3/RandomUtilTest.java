package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import static org.assertj.core.api.Assertions.assertThat;

class RandomUtilTest {
    private final int RANGE_TO_MOVE_POINT = 10;

    @RepeatedTest(10)
    @DisplayName("[랜덤 요소 존재] RandomUtil 에 의해 생성되는 데이터가 올바른 범위를 가지는지 테스트")
    void generateRandomNumber() {
        assertThat(RandomUtil.generateRandomNumber(RANGE_TO_MOVE_POINT)).matches(randomNumber -> (0 <= randomNumber && randomNumber < RANGE_TO_MOVE_POINT));
    }
}