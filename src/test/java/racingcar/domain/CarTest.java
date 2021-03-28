package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.strategy.MoveStrategy;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CarTest {

    private final static String carName = "test";

    static Stream<Arguments> distances() {
        return Stream.of(
                Arguments.of(new MoveStrategy[]{() -> false, () -> false, () -> false}, new Car(carName, 0)),
                Arguments.of(new MoveStrategy[]{() -> true, () -> true, () -> true}, new Car(carName, 3)),
                Arguments.of(new MoveStrategy[]{() -> true, () -> false, () -> true}, new Car(carName, 2))
        );
    }

    @Test
    @DisplayName("전진 테스트")
    void moveTrue() {
        Car car = new Car(new Name(carName));
        car.move(() -> true);
        assertThat(car.getPosition().position()).isEqualTo(1);
    }

    @Test
    @DisplayName("멈춤 테스트")
    void moveFalse() {
        Car car = new Car(new Name(carName));
        car.move(() -> false);
        assertThat(car.getPosition().position()).isEqualTo(0);
    }

    @ParameterizedTest
    @DisplayName("이동거리 확인 테스트")
    @MethodSource("distances")
    void checkPosition(MoveStrategy[] positions, Car expected) {
        Car actual = new Car(new Name("test"));
        for (MoveStrategy moveStrategy : positions) {
            actual.move(moveStrategy);
        }
        assertEquals(expected, actual);
    }
}
