package racingcar.domain.moving;

import static org.assertj.core.api.Assertions.*;
import static racingcar.domain.moving.Moving.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class RandomMovingStrategyTest {
    @DisplayName("랜덤값이 4 이상이면 GO 를 리턴하고 아니라면 STOP 을 리턴한다.")
    @ParameterizedTest
    @MethodSource("goSet")
    void go(int randomValue, Moving expected) {
        MovingStrategy randomMovingStrategy = new MockRandomMovingStrategy() {
            @Override
            int randomValue() {
                return randomValue;
            }
        };
        
        assertThat(randomMovingStrategy.go()).isEqualTo(expected);
    }

    private static Stream<Arguments> goSet() {
        return Stream.of(Arguments.arguments(3, STOP), Arguments.arguments(4, GO));
    }
}

abstract class MockRandomMovingStrategy extends RandomMovingStrategy {}
