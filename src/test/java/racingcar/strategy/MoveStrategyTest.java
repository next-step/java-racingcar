package racingcar.strategy;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("움직임 전략 인터페이트 테스트")
class MoveStrategyTest {

    @DisplayName("움직일 수 있는지 여부에 대한 함수 테스트")
    @ParameterizedTest
    @MethodSource
    void isMovable(MoveStrategy moveStrategy, boolean expectedResult) {
        assertThat(moveStrategy.isMovable()).isEqualTo(expectedResult);
    }

    private static Stream<Arguments> isMovable() {
        return Stream.of(
                Arguments.of((MoveStrategy) () -> false, false),
                Arguments.of((MoveStrategy) () -> true, true)
        );
    }
}