package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RamdomConditionTest {
    @Test
    @DisplayName("random 값이 4이상일 경우 조건 만족, 4 미만일 경우 실패인지 확인한다")
    void meet() {
        RamdomCondition meetRandomCondition = new RamdomCondition(5);
        assertThat(meetRandomCondition.meet()).isTrue();

        RamdomCondition unmeetRandomCondition = new RamdomCondition(2);
        assertThat(unmeetRandomCondition.meet()).isFalse();
    }
}
