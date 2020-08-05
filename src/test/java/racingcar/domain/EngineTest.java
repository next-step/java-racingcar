package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class EngineTest {

    @DisplayName("랜덤 엔진 테스트")
    @RepeatedTest(100)
    public void randomEngineTest() {
        Engine engine = new Engine();
        assertThat(engine.move())
                .isGreaterThanOrEqualTo(0)
                .isLessThanOrEqualTo(1);
    }

    @DisplayName("엔진의 기본 전진 룰 전진 테스트")
    @ParameterizedTest
    @ValueSource(ints = { 5, 6, 7, 8, 9 })
    public void defaultRuleMoveTest(int power) {
        assertThat(new Engine(() -> power).move()).isEqualTo(1);
    }

    @DisplayName("엔진의 기본 전진 룰 정지 테스트")
    @ParameterizedTest
    @ValueSource(ints = { 0, 1, 2, 3 })
    public void defaultRuleStopTest(int power) {
        assertThat(new Engine(() -> power).move()).isEqualTo(0);
    }

    @DisplayName("엔진의 커스텀 룰 전진 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1:2", "1:3", "2:5"}, delimiter = ':')
    public void defaultCustomRuleMoveTest(int enough, int power) {
        Engine engine = new Engine(
                (condition) -> condition >= enough,
                () -> power);
        assertThat(engine.move()).isEqualTo(1);
    }

    @DisplayName("엔진의 커스텀 룰 정지 테스트")
    @ParameterizedTest
    @CsvSource(value = {"5:0", "4:1", "9:8"}, delimiter = ':')
    public void defaultCustomRuleStopTest(int enough, int power) {
        Engine engine = new Engine(
                (condition) -> condition >= enough,
                () -> power);
        assertThat(engine.move()).isEqualTo(0);
    }
}
