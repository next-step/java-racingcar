package racingcar;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatCode;

public class RacingGameResultTest {


    @MethodSource("provideCarArgument")
    @ParameterizedTest
    @DisplayName("RacingResult 추가 테스트")
    public void generateRacingGameTest(Car[] cars) {

        RacingGameResult result = new RacingGameResult();
        assertThatCode(() -> result.add(cars)).doesNotThrowAnyException();

    }

    private static Stream<Arguments> provideCarArgument() {
        return Stream.of(
                Arguments.of(new Car[]{ Car.newInstance("k5"), Car.newInstance("sonata")}),
                Arguments.of(new Car[]{ Car.newInstance("k9"), Car.newInstance("ray"), Car.newInstance("genesis")})
        );
    }
}
