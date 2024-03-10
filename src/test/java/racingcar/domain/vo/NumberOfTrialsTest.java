package racingcar.domain.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowableOfType;

@DisplayName("시도 횟수 값 객체 테스트")
class NumberOfTrialsTest {
    @DisplayName("시도 횟수가 1 미만일 경우 예외가 발생한다")
    @ParameterizedTest(name = "{0}")
    @ValueSource(ints = {-100, -1, 0})
    void exceptionShouldBeThrownForLessThan1Trial(final int numberOfTrials) {
        // given & when
        final RuntimeException actual = catchThrowableOfType(
                () -> NumberOfTrials.from(numberOfTrials), RuntimeException.class);

        // then
        assertThat(actual).hasMessage("시도 횟수는 1회 이상이어야 합니다");
    }

    @DisplayName("시도 횟수가 1 이상일 경우 예외가 발생하지 않는다")
    @ParameterizedTest(name = "{0}")
    @ValueSource(ints = {1, 10, 100})
    void exceptionShouldBeThrownForMoreThan1Trial(final int numberOfTrials) {
        // given & when
        final NumberOfTrials actual = NumberOfTrials.from(numberOfTrials);

        // then
        assertThat(actual.getValue()).isEqualTo(numberOfTrials);
    }
}
