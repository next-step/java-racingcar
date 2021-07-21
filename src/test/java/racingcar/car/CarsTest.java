package racingcar.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import racingcar.helper.Fixture;
import racingcar.strategy.MoveStrategy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
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

    @DisplayName("자동차 이름은 null 이거나 빈값이 될 수 없다.")
    @NullAndEmptySource
    @ParameterizedTest
    void carsNameCantBeNull(String... names) {
        assertThatThrownBy(() -> Cars.init(names)).isInstanceOf(IllegalArgumentException.class);
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

    @DisplayName("자동차 그룹에서 가장 앞서있는 리더를 리턴한다.")
    @MethodSource
    @ParameterizedTest
    void leaderCarOfCars(int totalRound, int numberOfCars, MoveStrategy moveStrategy, List<String> leaders) {
        Cars cars = Fixture.testCars(numberOfCars);

        IntStream.range(0, totalRound)
                .forEach(i -> cars.moveCars(moveStrategy));

        assertThat(cars.getLeaders()).containsAll(leaders);
    }

    private static Stream<Arguments> leaderCarOfCars() {
        return Stream.of(
                Arguments.of(
                        10,
                        2,
                        new TrueFalseStrategy(),
                        Arrays.asList("0")
                ),
                Arguments.of(
                        10,
                        3,
                        new TrueTrueFalseStrategy(),
                        Arrays.asList("0", "1")
                ),
                Arguments.of(
                        10,
                        10,
                        new TrueFalseStrategy(),
                        Arrays.asList("0", "2", "4", "6", "8")
                )
        );
    }

    private static class TrueFalseStrategy implements MoveStrategy {
        private int count;

        @Override
        public boolean isMovable() {
            return ++count % 2 != 0;
        }
    }

    private static class TrueTrueFalseStrategy implements MoveStrategy {
        private int count;

        @Override
        public boolean isMovable() {
            return ++count % 3 != 0;
        }
    }
}
