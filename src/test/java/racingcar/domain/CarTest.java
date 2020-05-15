package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class CarTest {

    private Car car;

    @BeforeEach
    void setUp() {
        car = Car.of("name");
    }

    @DisplayName("Car 생성 시 distance 를 0으로 초기화")
    @Test
    void create() {
        assertThat(car.getPosition()).isEqualTo(Car.DEFAULT_DISTANCE);
    }

    @DisplayName("Car 생성 실패: name 이 빈 문자열이나 null 인 경우 예외 발생")
    @ParameterizedTest
    @NullAndEmptySource
    void failureCreate(final String name) {
        assertThatIllegalArgumentException().isThrownBy(() -> Car.of(name));
    }

    @DisplayName("Car 이동 실패: 전략이 null 인 경우")
    @Test
    void failureMove() {
        assertThatIllegalArgumentException().isThrownBy(() -> car.move(null));
    }

    @DisplayName("Car 는 이동 또는 정지")
    @ParameterizedTest
    @MethodSource("moveCase")
    void move(final boolean moveOrNot, final int distance) {
        car.move(() -> moveOrNot);
        assertThat(car.getPosition()).isEqualTo(Car.DEFAULT_DISTANCE + distance);
    }

    private static Stream<Arguments> moveCase() {
        return Stream.of(
                Arguments.of(true, 1),
                Arguments.of(false, 0)
        );
    }

    @DisplayName("Car 의 위치가 인자로 들어온 위치값과 같은 경우 true 반환")
    @ParameterizedTest
    @MethodSource("moveCase")
    void isSamePosition(final boolean moveOrNot, final int distance) {
        car.move(() -> moveOrNot);
        assertThat(car.isSamePosition(Car.DEFAULT_DISTANCE + distance)).isTrue();
    }
}
