package racingcar.strategy;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Random;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("랜덤 MoveStrategy 테스트")
class RandomMoveStrategyTest {

    @DisplayName("랜덤 객체를 가지고 초기화 한다.")
    @Test
    void init() {
        assertThat(RandomMoveStrategy.from(new Random())).isNotNull();
    }

    @DisplayName("랜덤 객체가 null 일 경우 예외를 발생시킨다.")
    @Test
    void initWithNull() {
        assertThatThrownBy(() -> RandomMoveStrategy.from(null)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("4를 기준으로 이상일 경우 true, 미만일 경우 false 를 리턴한다.")
    @ParameterizedTest
    @MethodSource
    void isMovable(Random random, boolean expectedValue) {
        assertThat(RandomMoveStrategy.from(random).isMovable()).isEqualTo(expectedValue);
    }

    private static Stream<Arguments> isMovable() {
        return Stream.of(
                Arguments.of(new Random() {
                    @Override
                    public int nextInt(int bound) {
                        return 4;
                    }
                }, true),

                Arguments.of(new Random() {
                    @Override
                    public int nextInt(int bound) {
                        return 10;
                    }
                }, false),

                Arguments.of(new Random() {
                    @Override
                    public int nextInt(int bound) {
                        return 3;
                    }
                }, false)
        );
    }

    @DisplayName("Random 이 한계값을 벗어나는 경우 예외를 발생시킨다")
    @ParameterizedTest
    @MethodSource
    void isMovableThrowExceptionWhenValueOutOfRange(Random random) {
        assertThatThrownBy(() -> RandomMoveStrategy.from(random).isMovable()).isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> isMovableThrowExceptionWhenValueOutOfRange() {
        return Stream.of(
                Arguments.of(new Random() {
                    @Override
                    public int nextInt(int bound) {
                        return -1;
                    }
                }),
                Arguments.of(new Random() {
                    @Override
                    public int nextInt(int bound) {
                        return 10;
                    }
                })
        );
    }
}
