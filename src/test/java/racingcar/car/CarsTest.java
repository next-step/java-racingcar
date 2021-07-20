package racingcar.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.helper.Fixture;
import racingcar.strategy.MoveStrategy;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("자동차 리스트 테스트")
class CarsTest {

    @DisplayName("자동차 리스트를 초기화 하는데는 차의 수, MoveStrategy 가 필요하다.")
    @Test
    void initCars() {
        assertThat(Cars.from(10)).isNotNull();
    }

    @DisplayName("자동차 수는 음수가 될 수 없다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    void numOfCarsShouldBeOverZero(int numberOfCars) {
        assertThatThrownBy(() -> Cars.from(numberOfCars)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차 전체 움직이기 테스트")
    @ParameterizedTest(name = "움직이기 전 위치 [{1}], 움직인 후 위치 [{2}]")
    @MethodSource
    void moveCars(Cars cars, MoveStrategy moveStrategy, int positionBeforeMove, int positionAfterMove) {
        cars.getCarDtos()
                .forEach(carDto -> assertThat(carDto.getPosition()).isEqualTo(positionBeforeMove));

        cars.moveCars(moveStrategy);

        cars.getCarDtos()
                .forEach(carDto -> assertThat(carDto.getPosition()).isEqualTo(positionAfterMove));
    }

    private static Stream<Arguments> moveCars() {
        return Stream.of(
                Arguments.of(Cars.from(10), Fixture.alwaysMoveStrategy(), 0, 1),
                Arguments.of(Cars.from(10), Fixture.neverMoveStrategy(), 0, 0)
        );
    }
}
