package racing.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalStateException;

public class PositionTest {

    @DisplayName("차 위치 초기값 테스트")
    @ParameterizedTest
    @ValueSource(ints = -1)
    void 차_위치_초기값은_0이상(int input) {
        assertThatIllegalStateException()
                .isThrownBy(() -> new Position(input))
                .withMessageMatching("음수값을 가질 수 없습니다.");
    }

}
