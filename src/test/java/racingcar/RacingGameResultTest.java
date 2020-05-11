package racingcar;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

public class RacingGameResultTest {

    @MethodSource("provideCarArgument")
    @ParameterizedTest
    @DisplayName("RacingResult 객체 생성 테스트")
    public void generateRacingGameResultTest(int[] positions, Car[] cars) {
        assertThatCode(() -> new RacingGameResult(cars)).doesNotThrowAnyException();
    }

    @MethodSource("provideCarArgument")
    @ParameterizedTest
    @DisplayName("RacingResult 추가 테스트")
    public void racingGameResultAddTest(int[] positions, Car[] cars) {
        RacingGameResult result = new RacingGameResult(cars);
        assertThatCode(() -> result.add(positions)).doesNotThrowAnyException();

        assertThat(result.getSize()).isEqualTo(1);
    }

    private static Stream<Arguments> provideCarArgument() {
        return Stream.of(
                Arguments.of(new int[]{0, 0, 1}, new Car[]{Car.newInstance("k5"), Car.newInstance("sonata")}),
                Arguments.of(new int[]{1, 1, 2}, new Car[]{Car.newInstance("k9"), Car.newInstance("ray"), Car.newInstance("genesis")})
        );
    }
}
