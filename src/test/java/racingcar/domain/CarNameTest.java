package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static racingcar.domain.CarName.CAR_NAME_LENGTH_EXCEPTION;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class CarNameTest {

    @ParameterizedTest
    @DisplayName("자동차 이름은 1자에서 5자 사이여야 한다.")
    @MethodSource("parametersProvider")
    void validate_car_name_length(String given, CarName expected) {
        // when
        CarName carName = new CarName(given);

        // then
        assertThat(carName).isEqualTo(expected);
    }

    private static Stream<Arguments> parametersProvider() {
        return Stream.of(
                arguments("k", new CarName("k")),
                arguments("k879", new CarName("k879"))
        );
    }

    @ParameterizedTest
    @DisplayName("자동차 이름은 1자에서 5자 사이가 아니면 예외를 던진다.")
    @ValueSource(strings = {"", " ", "k23126", "suzhanlee"})
    void create_racing_car_with_car_name_exception(String given) {
        // when  // then
        assertThatThrownBy(() -> new CarName(given))
                .isExactlyInstanceOf(IllegalStateException.class)
                .hasMessage(CAR_NAME_LENGTH_EXCEPTION);
    }
}
