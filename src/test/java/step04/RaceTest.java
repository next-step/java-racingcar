package step04;

import exception.NotPositiveIntegerException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class RaceTest {
    Cars cars;

    @BeforeEach
    void setup() {
        cars = Cars.of("pobi,crong,honux", 1, () -> true);
    }

    private static Stream<Arguments> provideRightRaceParamResult() {
        return Stream.of(
                Arguments.of(3),
                Arguments.of(1),
                Arguments.of(10)
        );
    }

    @DisplayName("Race 올바른 인자 numberOfMoves 생성자 테스트")
    @ParameterizedTest
    @MethodSource("provideRightRaceParamResult")
    public void Given_RightParam_When_RaceConstruct_Then_doesNotThrowAnyException(int numberOfMoves) {
        assertThatCode(() -> Race.of(numberOfMoves, cars))
                .doesNotThrowAnyException();
    }

    private static Stream<Arguments> provideWrongRaceParamResult() {
        return Stream.of(
                Arguments.of(0),
                Arguments.of(-1),
                Arguments.of(-10)
        );
    }

    @DisplayName("Race 올바르지 않은 인자 numberOfMoves 생성자 테스트")
    @ParameterizedTest
    @MethodSource("provideWrongRaceParamResult")
    public void Given_WrongParam_When_RaceConstruct_Then_ThrowException(int numberOfMoves) {
        assertThatExceptionOfType(NotPositiveIntegerException.class)
                .isThrownBy(() -> Race.of(numberOfMoves, cars));
    }

    @DisplayName("Race 정상 운영 테스트")
    @Test
    public void operate_doesNotThrowAnyException() {
        ResultView resultView = ResultView.of("-");
        assertThatCode(() -> Race.of(3, cars).operate(resultView))
                .doesNotThrowAnyException();
    }

}
