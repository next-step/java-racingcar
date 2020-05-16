package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class CarTest {


    @ValueSource(strings = {"ray", "genesis"})
    @ParameterizedTest
    @DisplayName("기본 Car 생성 메소드 테스트")
    void newInstanceTest(String name) {
        assertThatCode(() -> Car.newInstance(CarName.of(name))).doesNotThrowAnyException();
        assertThatCode(() -> Car.newInstance(CarName.of(name), new RandomMovableStrategy())).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("움직임 전략이 null 이면 예외가 발생한다.")
    void generateCarNewInstanceWithMovableStrategyNullTest() {
        assertThatNullPointerException()
                .isThrownBy(() -> Car.newInstance(CarName.of("ray"), null));
    }

    @MethodSource("generateCar")
    @ParameterizedTest
    @DisplayName("차가 움직이면 값이 현재위치와 같거나 이상의 값을 가질 수 있다.")
    void moveTest(Car car) {
        assertThat(car.move()).isGreaterThanOrEqualTo(car.getPosition());
    }

    @ValueSource(ints = {1, 2, 3})
    @ParameterizedTest
    @DisplayName("차의 clear method를 수행하면 위치값이 초기화된다.")
    void clearPositionTest(int position) {
        Car car = Car.newInstance(CarPosition.of(position), CarName.of("test"), new RandomMovableStrategy());
        car.clearPosition();
        assertThat(car.getPosition()).isZero();
    }

    static Stream<Arguments> generateCar() {
        return Stream.of(
                Arguments.of(Car.newInstance(CarName.of("ray"))),
                Arguments.of(Car.newInstance(CarName.of("genesis"))),
                Arguments.of(Car.newInstance(CarName.of("sonata")))
        );
    }
}
