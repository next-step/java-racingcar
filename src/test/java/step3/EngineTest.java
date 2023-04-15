package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class EngineTest {

    @DisplayName("4 미만의 값이 주어질 때 엔진 테스트")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 3})
    void isNotOkWhenEngineConditionIsLessThan4(int value) {
        Engine engine = new Engine(() -> value);
        assertThat(engine.canStart())
                .isFalse();
    }

    @DisplayName("4 이상의 값이 주어질 때 엔진 테스트")
    @ParameterizedTest
    @ValueSource(ints = {4, 6, 9})
    void isOkWhenEngineConditionIsGraterThanOrEqual4(int value) {
        Engine engine = new Engine(() -> value);
        assertThat(engine.canStart())
                .isTrue();
    }
}
