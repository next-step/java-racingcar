package carracing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@DisplayName("자동차들의 이름을 위한 테스트")
class CarNameGroupTest {
    private static final String TEST_CAR_NAMES = "pobi,crong,honux";

    @DisplayName("유효한 자동차들의 이름이 생성되는지 확인")
    @ParameterizedTest
    @ValueSource(strings = {TEST_CAR_NAMES})
    void createValidCarNamesTest(String validCarNames) {
        // When
        CarNameGroup actual = new CarNameGroup(validCarNames);

        // Then
        assertThat(actual).isNotNull();
    }

    @DisplayName("유효하지 않은 자동차들의 이름이 예외를 발생하는지 확인")
    @ParameterizedTest
    @NullAndEmptySource
    void checkExceptionWithInvalidCarNamesTest(String invalidCarNames) {
        // When & Then
        assertThatIllegalArgumentException().isThrownBy(
                () -> new CarNameGroup(invalidCarNames)
        );
    }
}
