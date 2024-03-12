package racingcar.step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.RandomPolicy;

import static org.assertj.core.api.Assertions.assertThat;

class RandomPolicyTest {

    private final static int position = 4;
    private RandomPolicy policy;

    @BeforeEach
    void setUp() {
        //given
         policy = new RandomPolicy();
    }

    @DisplayName("성공시 한 칸 진행, 실패시 미진행")
    @Test
    void attemptResultValidation() {

        int newPosition = policy.apply(position);
        if (policy.isAttemptsSuccess()) {
            assertThat(newPosition).isGreaterThan(position);
        }
        if (!policy.isAttemptsSuccess()) {
            assertThat(newPosition).isLessThan(position);
        }

    }
}
