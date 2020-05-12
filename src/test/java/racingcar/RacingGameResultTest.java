package racingcar;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class RacingGameResultTest {

    @MethodSource("provideCarArgument")
    @ParameterizedTest
    @DisplayName("RacingResult 객체 생성 테스트")
    public void generateRacingGameResultTest(int[] positions, Car[] cars) {
        assertThatCode(() -> new RacingGameResult(cars)).doesNotThrowAnyException();
    }

    @MethodSource("provideCarArgument")
    @ParameterizedTest
    @DisplayName("RacingResult 객체 생성 시 레이싱 게임 결과에는 시작 위치 1개가 존재한다.")
    public void resultSizeTest(int[] positions, Car[] cars) {
        assertThat(new RacingGameResult(cars).getResults()).hasSize(1);
    }

    @MethodSource("provideCarArgument")
    @ParameterizedTest
    @DisplayName("RacingResult 추가 테스트")
    public void racingGameResultAddTest(int[] positions, Car[] cars) {
        RacingGameResult result = new RacingGameResult(cars);
        assertThatCode(() -> result.add(positions)).doesNotThrowAnyException();

        assertThat(result.getSize()).isEqualTo(2);
    }

    @MethodSource("provideInvalidCarArgument")
    @ParameterizedTest
    @DisplayName("RacingResult 추가 테스트")
    public void racingGameResultAddExceptionTest(int[] positions, Car[] cars) {
        RacingGameResult result = new RacingGameResult(cars);
        assertThatIllegalArgumentException().isThrownBy(() -> result.add(positions));
    }

    @MethodSource("winnerArgument")
    @ParameterizedTest
    @DisplayName("RacingResult 우승자 계산 테스트")
    public void GetWinnerTest(int[] positions, Car[] cars, String expected) {

        RacingGameResult result = new RacingGameResult(cars);
        result.add(positions);

        assertThatCode(() -> result.getWinner()).doesNotThrowAnyException();
        assertThat(result.getWinner()).isEqualTo(expected);
    }

    private static Stream<Arguments> provideCarArgument() {
        return Stream.of(
                Arguments.of(new int[]{0, 0, 1}, new Car[]{Car.newInstance("k5"), Car.newInstance("sonata"), Car.newInstance("genesis")}),
                Arguments.of(new int[]{1, 1, 2}, new Car[]{Car.newInstance("k9"), Car.newInstance("ray"), Car.newInstance("genesis")})
        );
    }

    private static Stream<Arguments> provideInvalidCarArgument() {
        return Stream.of(
                Arguments.of(new int[]{0, 0}, new Car[]{Car.newInstance("k5"), Car.newInstance("sonata"), Car.newInstance("genesis")}),
                Arguments.of(new int[]{1, 2, 3, 4}, new Car[]{Car.newInstance("k9"), Car.newInstance("ray"), Car.newInstance("genesis")})
        );
    }

    private static Stream<Arguments> winnerArgument() {

        Car winner1 = Car.newInstance("genesis");
        winner1.setPosition(2);

        Car winner2 = Car.newInstance("ray");
        winner2.setPosition(2);

        return Stream.of(
                Arguments.of(new int[]{0, winner1.getPosition(), winner2.getPosition()},
                        new Car[]{Car.newInstance("k5"), winner1, winner2}, winner1.getName() + "," + winner2.getName()),
                Arguments.of(new int[]{1, 1, winner2.getPosition()},
                        new Car[]{Car.newInstance("k9"), Car.newInstance("sonata"), winner2}, winner2.getName())
        );
    }
}
