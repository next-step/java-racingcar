package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("RacingGame 생성 테스트")
class RacingGameTest {

    @DisplayName("null이거나 비어 있는 리스트로 생성 시 exception 발생")
    @ParameterizedTest
    @NullAndEmptySource
    void nullOrEmptyCarNamesThrowsException(List<String> carNames) {
        // when & then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new RacingGame(carNames, 3));
        assertThat(exception.getMessage()).isEqualTo("자동차 이름이 비어 있습니다.");
    }

    @DisplayName("null이거나 blank인 carName이 포함된 리스트로 생성 시 exception 발생")
    @ParameterizedTest
    @MethodSource("provideCarNames")
    void nullOrBlankCarNameThrowsException(String car1, String car2, String car3) {
        // given
        List<String> carNames = Arrays.asList(car1, car2, car3);

        // when & then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new RacingGame(carNames, 3));
        assertThat(exception.getMessage()).isEqualTo("이름이 없는 자동차가 있습니다.");
    }

    private static Stream<Arguments> provideCarNames() {
        return Stream.of(
                Arguments.of("car1", " ", "car3"),
                Arguments.of("car1", null, "car3"),
                Arguments.of("", "car2", "car3")
        );
    }

    @DisplayName("1보다 작은 round로 생성 시 exception 발생")
    @Test
    void roundsBelowOneThrowsException() {
        // given
        List<String> carNames = List.of("car1", "car2", "car3");

        // when & then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new RacingGame(carNames, 0)
        );
        assertThat(exception.getMessage()).isEqualTo("라운드는 최소 1 이상이어야 합니다.");
    }
}