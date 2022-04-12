package study.step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingCarTest {

    @DisplayName("0~9 사이의 random 값 생성기")
    @RepeatedTest(100)
    void numberGenerator() {
        int val = NumberGenerator.randomVal(10);

        assertThat(val).isGreaterThan(-1).isLessThan(10);
    }

    @DisplayName("사용자는 시도 횟수를 입력할 수 있다")
    @Test
    void tryInputNum() {

    }
}
