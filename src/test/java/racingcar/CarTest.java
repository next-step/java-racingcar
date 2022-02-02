package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.domain.Car;

public class CarTest {

    static Stream<String> invalidCarNames() {
        return Stream.of("", "INVALID_PLAYER_NAME");
    }

    @DisplayName("개별 플레이어의 이름 유효성 검사 (성공)")
    @Test
    void testCarNameValid() {
        assertDoesNotThrow(() -> new Car("OK"));
    }

    @DisplayName("개별 플레이어의 이름 유효성 검사 (실패)")
    @ParameterizedTest
    @MethodSource("invalidCarNames")
    void testCarNameInvalid(String carName) {
        assertThatThrownBy(() -> new Car(carName))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("임의의 플레이어가 의도한대로 이동하였는지 테스트")
    @Test
    void testCarRunnable() {
        // Given
        Car carA = new Car("A");
        List<Boolean> moves = Arrays.asList(true, false, true, false, true);
        int moved = 3;

        // When
        carMove(carA, moves);

        // Then
        assertThat(carA.distance())
            .isEqualTo(moved);
    }

    // 자동차 이동 로직
    void carMove(Car car, List<Boolean> moves) {
        for (boolean carMoved : moves) {
            car.run(() -> carMoved);
        }
    }
}
