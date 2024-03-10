package racingcar.domain.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowableOfType;

@DisplayName("자동차 수 값 객체 테스트")
class NumberOfCarsTest {
    @DisplayName("자동차 수가 1대 미만일 경우 예외가 발생한다")
    @ParameterizedTest(name = "{0}")
    @ValueSource(ints = {-100, -1, 0})
    void exceptionShouldBeThrownForLessThan1Car(final int numberOfCars) {
        // given & when
        final RuntimeException actual = catchThrowableOfType(
                () -> NumberOfCars.from(numberOfCars), RuntimeException.class);

        // then
        assertThat(actual).hasMessage("자동차는 1대 이상이어야 합니다");
    }

    @DisplayName("자동차 수가 1대 이상일 경우 예외가 발생하지 않는다")
    @ParameterizedTest(name = "{0}")
    @ValueSource(ints = {1, 10, 100})
    void exceptionShouldBeThrownForMoreThan1Car(final int numberOfCars) {
        // given & when
        final NumberOfCars actual = NumberOfCars.from(numberOfCars);

        // then
        assertThat(actual.getValue()).isEqualTo(numberOfCars);
    }
}
