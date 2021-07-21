package racingcar.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.helper.Fixture;
import racingcar.strategy.RandomMoveStrategy;

import java.util.Random;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("자동차 클래스 테스트")
class CarTest {

    @DisplayName("자동차는 이름을 부여할 수 있다.")
    @ValueSource(strings = {"nok", "cha", "x"})
    @ParameterizedTest
    void initWithMoveStrategy(String name) {
        assertThat(Car.from(name)).isNotNull();
    }

    @DisplayName("MoveStrategy 가 true 일 경우 자동차는 +1 만큼 이동한다.")
    @Test
    void carMoveWhenMoveStrategyReturnTrue() {
        Car car = Car.newInstance();

        assertThat(car.currentPosition()).isEqualTo(0);

        car.move(Fixture.alwaysMoveStrategy());

        assertThat(car.currentPosition()).isEqualTo(1);
    }

    @DisplayName("MoveStrategy 가 false 일 경우 움직이지 않는다.")
    @Test
    void carDoesNotMoveWhenMoveStrategyReturnFalse() {
        Car car = Car.newInstance();

        assertThat(car.currentPosition()).isEqualTo(0);

        car.move(Fixture.neverMoveStrategy());

        assertThat(car.currentPosition()).isEqualTo(0);
    }

    @DisplayName("MoveStrategy 가 null 일 경우 예외를 던진다.")
    @Test
    void moveThrowExceptionWhenMoveStrategyIsNull() {
        Car car = Car.newInstance();

        assertThatThrownBy(() -> car.move(null)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4이상일 경우이다.")
    @ParameterizedTest
    @MethodSource
    void moveTestWithMoveStrategy(Random random, boolean moved) {
        boolean notMoved = !moved;
        Car car = Car.newInstance();
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
