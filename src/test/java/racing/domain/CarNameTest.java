package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("자동차 이름 객체 관련 테스트")
class CarNameTest {

    @DisplayName("자동차 이름은 5글자까지 입력한다.")
    @ParameterizedTest
    @ValueSource(strings = {"미니쿠퍼", "레인지로버"})
    void car_create(final String name) {

        final CarName carName = new CarName(name);

        assertThat(carName.getName()).isEqualTo(name);
    }

    @DisplayName("자동차 이름은 빈 값, null 값을 입력하며 익셉션 처리한다.")
    @ParameterizedTest
    @NullAndEmptySource
    void error_car_create(final String name) {

        assertThatThrownBy(() -> new CarName(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 필수값입니다.");
    }

    @DisplayName("스페이스만 입력한 이름도 익셉션 처리한다.")
    @Test
    void error_car_create2() {

        assertThatThrownBy(() -> new CarName("     "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 필수값입니다.");
    }

    @DisplayName("입력된 사용자 이름을 , 로 잘라서 목록으로 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"pobi:1", "pobi,:1", "pobi,crong:2", "pobi,crong,honux:3"}, delimiter = ':')
    void input_name(final String input, final int size) {

        final List<CarName> carNames = CarName.from(input);

        assertThat(carNames).hasSize(size);
    }

    @DisplayName("입력된 자동차 이름이 빈 값이 포함되어 있다면 익셉션 처리한다.")
    @ParameterizedTest
    @ValueSource(strings = {",pobi,", " ,pobi, "})
    void error_input_name(final String input) {

        assertThatThrownBy(() -> CarName.from(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 필수값입니다.");
    }

    @DisplayName("입력된 자동차 이름이 없으면 예외 처리를 한다.")
    @ParameterizedTest
    @NullAndEmptySource
    void error_input_null_empty(final String input) {

        assertThatThrownBy(() -> CarName.from(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 필수값입니다.");
    }
}
