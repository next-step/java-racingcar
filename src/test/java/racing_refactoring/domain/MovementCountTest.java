package racing_refactoring.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;


class MovementCountTest {

    @DisplayName("이동 횟수가 1 이하일 경우")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    void construct_fail(int movementCount) {
        assertThatThrownBy(() -> new MovementCount(movementCount)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도할 회수는 1회 이상이어야 합니다.");
    }
}