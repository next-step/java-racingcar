package racingcar.domain;

import static org.assertj.core.api.Assertions.*;
import static racingcar.domain.moving.Moving.*;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import racingcar.domain.exception.InvalidCarCountException;

class RacingTest {
    @DisplayName("자동차 대수나 시도 횟수가 유효하다면 Racing 객체를 리턴한다.")
    @ParameterizedTest
    @MethodSource("cars")
    void of(CarNames names, int tryCount) {
        assertThat(Racing.of(names, tryCount)).isNotNull().isInstanceOf(Racing.class);
    }
    
    @DisplayName("자동차 대수나 시도 횟수가 유효하지 않으면 IllegalArgumentException 예외를 발생시킨다.")
    @ParameterizedTest
    @MethodSource("invalidCars")
    void of_when_invalid_count(CarNames names, int tryCount) {
        assertThatThrownBy(() -> {
            Racing.of(names, tryCount);
        }).isInstanceOf(InvalidCarCountException.class).hasMessageMatching("Number of cars is greater than 0 and trial count must be greater than or equal to 1.");
    }

    @DisplayName("이동전략을 이용하여 자동차들을 이동시킨다.")
    @Test
    void race() {
        Racing racing = new Racing(
                new Progress(0), 
                new Cars(List.of(new Car("pobby"), new Car("luna")))
        );
        
        assertThat(racing.race(() -> GO)).hasSameElementsAs(
                List.of(
                        new Car("pobby", new Distance(1)),
                        new Car("luna", new Distance(1))
                )
        );
    }

    @DisplayName("경기가 종료되었다면 true 를 리턴하고 진행중이라면 false 를 리턴한다.")
    @ParameterizedTest
    @MethodSource("isFinishSet")
    void isFinish(Racing racing, boolean expected) {
        assertThat(racing.isFinish()).isEqualTo(expected);
    }

    private static Stream<Arguments> isFinishSet() {
        return Stream.of(
            Arguments.arguments(new Racing(new Progress(1, 1), new Cars(List.of())), true),
            Arguments.arguments(new Racing(new Progress(3, 1), new Cars(List.of())), false)
        );
    }
    
    private static Stream<Arguments> cars() {
        return Stream.of(
                Arguments.arguments(CarNames.of("pobby"), 1),
                Arguments.arguments(CarNames.of("pobby, crong"), 1),
                Arguments.arguments(CarNames.of("crong"), 2),
                Arguments.arguments(CarNames.of("pobby, honux, james, tim, luna"), 4)
        );
    }

    private static Stream<Arguments> invalidCars() {
        return Stream.of(
                Arguments.arguments(CarNames.of(","), 1),
                Arguments.arguments(CarNames.of("pobby"), 0),
                Arguments.arguments(CarNames.of(","), 0)
        );
    }
}
