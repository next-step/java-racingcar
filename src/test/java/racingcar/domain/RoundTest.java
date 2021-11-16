package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.exception.RoundException;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RoundTest {

    @ParameterizedTest
    @DisplayName("Round 생성 테스트")
    @MethodSource
    void createRoundTest(int tryCount, Round expected) {
        Round round = Round.from(tryCount);

        assertThat(round).isEqualTo(expected);
    }

    static Stream<Arguments> createRoundTest() {
        return Stream.of(
                Arguments.of(
                        0, Round.from(0)
                ),
                Arguments.of(
                        1, Round.from(1)
                ),
                Arguments.of(
                        2, Round.from(2)
                )
        );
    }

    @ParameterizedTest
    @DisplayName("0이하의 라운드를 입력하면 예외 발생")
    @ValueSource(ints = {-1, -2, -3})
    void createRoundExceptionTest(int value) {
        assertThatThrownBy(() -> Round.from(value)).isInstanceOf(RoundException.class);
    }

    @ParameterizedTest
    @DisplayName("라운드가 0이 되면 Round#isOver true 그렇지 않으면 false를 리턴한다.")
    @MethodSource
    void isOverTest(Round round, boolean expected) {
        assertThat(round.isOver()).isEqualTo(expected);
    }

    static Stream<Arguments> isOverTest() {
        return Stream.of(
                Arguments.of(
                        Round.from(0), Boolean.TRUE
                ),
                Arguments.of(
                        Round.from(1), Boolean.FALSE
                ),
                Arguments.of(
                        Round.from(2), Boolean.FALSE
                )
        );
    }

}