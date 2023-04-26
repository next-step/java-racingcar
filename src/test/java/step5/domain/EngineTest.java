package step5.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step3.Engine;

import static org.assertj.core.api.Assertions.assertThat;

class EngineTest {

    @DisplayName("정지 조건 테스트")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 3})
    void isNotOkWhenEngineConditionIsLessThan4(int value) {
        Engine engine = new Engine(() -> value);
        assertThat(engine.canStart())
                .isFalse();
    }

    @DisplayName("전진 조건 테스트")
    @ParameterizedTest
    @ValueSource(ints = {4, 6, 9})
    void isOkWhenEngineConditionIsGraterThanOrEqual4(int value) {
        Engine engine = new Engine(() -> value);
        assertThat(engine.canStart())
                .isTrue();
    }
}
