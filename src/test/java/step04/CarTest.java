package step04;

import exception.EmptyException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class CarTest {

    @DisplayName("빈 이름으로 자동차 생성 테스트")
    @ParameterizedTest
    @NullAndEmptySource
    public void validateName_Exception(String name) {
        assertThatExceptionOfType(EmptyException.class)
                .isThrownBy(() -> {
                    Car.of("", 0, () -> true);
                });
    }

    private static Stream<Arguments> providePositionResult() {
        return Stream.of(
                Arguments.of(0, 0),
                Arguments.of(10, 10),
                Arguments.of(100, 100)
        );
    }

    @DisplayName("initPosition 과 expected 가 동일해야 함")
    @ParameterizedTest
    @MethodSource("providePositionResult")
    public void test_getPosition(int initPosition, int expected) {
        Car car = Car.of("carName", initPosition, () -> true);
        int result = car.getPosition();

        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> provideMovingCarResult() {
        return Stream.of(
            Arguments.of(true, 0, 1),
            Arguments.of(false, 0, 0),
            Arguments.of(false, 1, 1),
            Arguments.of(true, 3, 4)
        );
    }

    @DisplayName("moveStrategy 가 true 이면 1 증가")
    @ParameterizedTest
    @MethodSource("provideMovingCarResult")
    public void test_move(boolean isMovable, int position, int expected) {
        Car car = Car.of("carName", position, () -> isMovable);
        car.move();

        int result = car.getPosition();
        assertThat(result).isEqualTo(expected);
    }
}

