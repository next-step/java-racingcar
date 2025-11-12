package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class RandomNumberTest {

    @ParameterizedTest(name = "입력값: {0}")
    @ValueSource(ints = {0, 9})
    void 생성자_랜덤값이_0_이상_그리고_9_이하이면_정상적으로_생성(int input) {
        assertThat(new RandomNumber(input).value()).isEqualTo(input);
    }

    @ParameterizedTest(name = "입력값: {0}")
    @ValueSource(ints = {-1, 10})
    void 생성자_랜덤값이_0_미만_또는_9_초과이면_예외발생(int input) {
        assertThatThrownBy(() -> new RandomNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("랜덤 값은 0 이상 9 이하이어야 합니다.");
    }

    @ParameterizedTest(name = "랜덤값={0}, 기준값={1}")
    @ValueSource(ints = {4, 9})
    void isGreaterThanOrEqual_랜덤값이_기준값_이상이면_true(int randomValue) {
        RandomNumber random = new RandomNumber(randomValue);

        assertThat(random.isGreaterThanOrEqual(4)).isTrue();
    }

    @ParameterizedTest(name = "랜덤값={0}, 기준값={1}")
    @ValueSource(ints = {0, 3})
    void isGreaterThanOrEqual_랜덤값이_기준값_미만이면_false(int randomValue) {
        RandomNumber random = new RandomNumber(randomValue);

        assertThat(random.isGreaterThanOrEqual(4)).isFalse();
    }
}
