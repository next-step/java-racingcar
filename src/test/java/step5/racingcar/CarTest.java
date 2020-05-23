package step5.racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import step5.racingcar.domain.Car;
import step5.racingcar.domain.CarFactory;
import step5.racingcar.domain.RandomMovingStrategy;

import java.util.List;
import java.util.stream.Stream;
import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @DisplayName("car 객체 생성 및 기본값 테스트")
    @Test
    public void makeNewCarObject() {
        Car car = new Car("abc");

        assertThat(car.getPosition()).isEqualTo(0);
    }

    @DisplayName("car 객체가 움직이는지 확인하는 테스트")
    @ParameterizedTest
    @MethodSource("mockMovableStrategy")
    public void checkWhetherCarObjectMoves(boolean isMovable, int distance) {
        Car car = new Car("test");

        car.move(() -> isMovable);

        assertThat(car.getPosition()).isEqualTo(distance);
    }

    private static Stream<Arguments> mockMovableStrategy() {
        return Stream.of(
                Arguments.of(true, 1),
                Arguments.of(false, 0)
        );
    }
}
