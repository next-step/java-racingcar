package carracing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@DisplayName("자동차들의 이름을 위한 테스트")
class CarNamesTest {
    private static final String POBI = "pobi";
    private static final String CRONG = "crong";
    private static final String HONUX = "honux";
    private static final String TEST_CAR_NAMES = POBI + "," + CRONG + "," + HONUX;

    @DisplayName("유효한 자동차들의 이름이 생성되는지 확인")
    @ParameterizedTest
    @ValueSource(strings = {TEST_CAR_NAMES})
    void createValidCarNamesTest(String validCarNames) {
        // when
        CarNames actual = new CarNames(validCarNames);
        // then
        assertThat(actual).isNotNull();
        assertThat(actual.getNames()).hasSize(3)
                .containsExactly(new CarName(POBI), new CarName(CRONG), new CarName(HONUX));
    }

    @DisplayName("유효하지 않은 자동차들의 이름이 예외를 발생하는지 확인")
    @ParameterizedTest
    @NullAndEmptySource
    void checkExceptionWithInvalidCarNamesTest(String invalidCarNames) {
        // when & then
        assertThatIllegalArgumentException().isThrownBy(
                () -> new CarNames(invalidCarNames)
        );
    }
}
