package racingcar.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.helper.Fixture;
import racingcar.strategy.RandomMoveStrategy;

import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("자동차 클래스 테스트")
class CarTest {

    @DisplayName("자동차는 이름을 부여할 수 있다.")
    @ValueSource(strings = {"nok", "cha", "x"})
    @ParameterizedTest
    void initWithMoveStrategy(String name) {
        Car car = Car.from(name);
        assertThat(car).isNotNull();
        assertThat(car.name()).isEqualTo(name);
    }

    @DisplayName("차 이름은 5자를 초과하거나 빈값 null 일 경우 예외를 발생한다.")
    @NullAndEmptySource
    @ValueSource(strings = {"123456", "overfive"})
    @ParameterizedTest
    void carNameLimit(String name) {
        assertThatThrownBy(() -> Car.from(name)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("MoveStrategy 가 true 일 경우 자동차는 +1 만큼 이동한다.")
    @Test
    void carMoveWhenMoveStrategyReturnTrue() {
        Car car = Fixture.testCar();

        assertThat(car.currentPosition()).isEqualTo(0);

        car.move(Fixture.ALWAYS_MOVE_STRATEGY);

        assertThat(car.currentPosition()).isEqualTo(1);
    }

    @DisplayName("MoveStrategy 가 false 일 경우 움직이지 않는다.")
    @Test
    void carDoesNotMoveWhenMoveStrategyReturnFalse() {
        Car car = Fixture.testCar();

        assertThat(car.currentPosition()).isEqualTo(0);

        car.move(Fixture.NEVER_MOVE_STRATEGY);

        assertThat(car.currentPosition()).isEqualTo(0);
    }

    @DisplayName("MoveStrategy 가 null 일 경우 예외를 던진다.")
    @Test
    void moveThrowExceptionWhenMoveStrategyIsNull() {
        Car car = Fixture.testCar();

        assertThatThrownBy(() -> car.move(null)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("주어진 포지션과 동일한 포지션인지 확인")
    @Test
    void isSamePosition() {
        Car car = Fixture.testCar();

        IntStream.rangeClosed(0, 10)
                .forEach(idx -> {
                    car.isSamePosition(idx);
                    car.move(Fixture.ALWAYS_MOVE_STRATEGY);
                });
    }

    @DisplayName("전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4이상일 경우이다.")
    @ParameterizedTest
    @MethodSource
    void moveTestWithMoveStrategy(Random random, boolean moved) {
        boolean notMoved = !moved;
        Car car = Fixture.testCar();
        RandomMoveStrategy staticRandomNumberMoveStrategy = RandomMoveStrategy.from(random);

        int positionBeforeMove = car.currentPosition();
        car.move(staticRandomNumberMoveStrategy);
        int positionAfterMove = car.currentPosition();

        assertThat(positionBeforeMove + 1 == positionAfterMove).isEqualTo(moved);
        assertThat(positionBeforeMove == positionAfterMove).isEqualTo(notMoved);
    }

    private static Stream<Arguments> moveTestWithMoveStrategy() {
        return Stream.of(
                Arguments.of(new Random() {
                    @Override
                    public int nextInt(int bound) {
                        return 0;
                    }
                }, false),

                Arguments.of(new Random() {
                    @Override
                    public int nextInt(int bound) {
                        return 3;
                    }
                }, false),

                Arguments.of(new Random() {
                    @Override
                    public int nextInt(int bound) {
                        return 4;
                    }
                }, true),

                Arguments.of(new Random() {
                    @Override
                    public int nextInt(int bound) {
                        return 9;
                    }
                }, true),

                Arguments.of(new Random() {
                    @Override
                    public int nextInt(int bound) {
                        return 10;
                    }
                }, false)
        );
    }
}
