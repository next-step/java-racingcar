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

    @DisplayName("자동차 집단을 초기화 하는데는 참가하는 사람들의 차 이름이 필요하다.")
    @Test
    void initCars() {
        assertThat(Cars.init("nok", "cha", "x")).isNotNull();
    }

    @DisplayName("자동차 수는 음수가 될 수 없다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    void numOfCarsShouldBeOverZero(int numberOfCars) {
        assertThatThrownBy(() -> Cars.from(numberOfCars)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차 이름은 null 이 되 수 없다.")
    @Test
    void carsNameCantBeNull() {
        assertThatThrownBy(() -> Cars.init(null)).isInstanceOf(IllegalArgumentException.class);
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
                Arguments.of(Fixture.testCars(), Fixture.ALWAYS_MOVE_STRATEGY, 0, 1),
                Arguments.of(Fixture.testCars(), Fixture.NEVER_MOVE_STRATEGY, 0, 0)
        );
    }
}
