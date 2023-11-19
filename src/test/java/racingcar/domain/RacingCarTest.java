package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static racingcar.domain.RacingCar.CAR_NAME_LENGTH_EXCEPTION;

import java.util.Arrays;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class RacingCarTest {

    @ParameterizedTest
    @DisplayName("경주차는 4이상의 수가 나오면 전진한다.")
    @CsvSource(value = {"4, 1", "3, 0"})
    void move(int randomNumber, int expectedPosition) {
        // given
        RacingCar racingCar = new RacingCar("tobi");

        // when
        racingCar.move(randomNumber);

        // then
        assertThat(racingCar).isEqualTo(new RacingCar("tobi", expectedPosition));
    }

    @Test
    @DisplayName("자동차 이름으로 경주차를 만든다.")
    void create_racing_car_with_car_name() {
        // given
        String carName = "pobi";

        // when
        RacingCar racingCar = new RacingCar(carName);

        // then
        assertThat(racingCar).isEqualTo(new RacingCar("pobi", 0));
    }

    @ParameterizedTest
    @DisplayName("자동차 이름은 1자에서 5자 사이여야 한다.")
    @MethodSource("parametersProvider")
    void validate_car_name_length(String given, RacingCar expected) {
        // when
        RacingCar racingCar = new RacingCar(given);

        // then
        assertThat(racingCar).isEqualTo(expected);
    }

    private static Stream<Arguments> parametersProvider() {
        return Stream.of(
                arguments("k", new RacingCar("k")),
                arguments("k879", new RacingCar("k879"))
        );
    }

    @ParameterizedTest
    @DisplayName("자동차 이름은 1자에서 5자 사이가 아니면 예외를 던진다.")
    @ValueSource(strings = {"", " ", "k23126", "suzhanlee"})
    void create_racing_car_with_car_name_exception(String given) {
        // when  // then
        assertThatThrownBy(() -> new RacingCar(given))
                .isExactlyInstanceOf(IllegalStateException.class)
                .hasMessage(CAR_NAME_LENGTH_EXCEPTION);
    }
}
