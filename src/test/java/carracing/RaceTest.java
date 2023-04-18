package carracing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static carracing.domain.Race.moveStatus;
import static org.assertj.core.api.Assertions.assertThat;

public class RaceTest {
    @ParameterizedTest
    @ValueSource(ints = {0, 3})
    @DisplayName("자동차 이동 실패 조건(0~3) 테스트")
    void moveFailConditionTest(int value) {
        assertThat(moveStatus(value)).isFalse();
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 9})
    @DisplayName("자동차 이동 성공 조건(4~9) 테스트")
    void moveSuccessConditionTest(int value) {
        assertThat(moveStatus(value)).isTrue();
    }
}
