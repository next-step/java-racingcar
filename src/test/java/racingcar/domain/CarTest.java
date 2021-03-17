package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
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
    Car car;

    @BeforeEach
    void setCar() {
        car = new Car();
    }

    @Test
    @DisplayName("전진 테스트")
    void moveTrue() {
        assertThat(car.move(() -> true)).isEqualTo(new Car(1));
    }
    @Test
    @DisplayName("멈춤 테스트")
    void moveFalse() {
        assertThat(car.move(() -> false)).isEqualTo(new Car(0));
    }


    static Stream<Arguments> distances() {
        return Stream.of(
                Arguments.of(new MoveStrategy[] {() -> false, () -> false, () -> false}, new Car(0)),
                Arguments.of(new MoveStrategy[] {() -> true, () -> true, () -> true}, new Car(3)),
                Arguments.of(new MoveStrategy[] {() -> true, () -> false, () -> true}, new Car(2))
        );
    }

    @ParameterizedTest
    @DisplayName("이동거리 확인 테스트")
    @MethodSource("distances")
    void checkPosition(MoveStrategy[] positions, Car expected) {
        for (MoveStrategy moveStrategy : positions) {
            car = car.move(moveStrategy);
        }
        assertEquals(expected, car);
    }
}
