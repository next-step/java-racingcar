package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("입력받는 자동차 이름 객체 관련 테스트")
class CarNamesTest {

    @DisplayName("입력된 사용자 이름을 , 로 잘라서 목록으로 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"pobi:1", "pobi,:1", "pobi,crong:2", "pobi,crong,honux:3"}, delimiter = ':')
    void input_name(final String input, final int size) {

        final CarNames carNames = CarNames.from(input);

        assertThat(carNames.list()).hasSize(size);
    }

    @DisplayName("입력된 사용자 중 이름이 빈 값이 포함되어 있다면 익셉션 처리한다.")
    @ParameterizedTest
    @ValueSource(strings = {",pobi,", " ,pobi, "})
    void error_input_name(final String input) {

        assertThatThrownBy(() -> CarNames.from(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 필수값입니다.");
    }

    @DisplayName("참여한 자동차가 없으면 예외 처리를 한다.")
    @ParameterizedTest
    @NullAndEmptySource
    void error_input_null_empty(final String input) {

        assertThatThrownBy(() -> CarNames.from(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 필수값입니다.");
    }
}
