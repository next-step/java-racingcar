package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.exception.RoundException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RoundTest {

    @ParameterizedTest
    @DisplayName("finalRound만 입력해서 생성하면, 시작 라운드는 0으로 생성 된다")
    @ValueSource(ints = {1, 2, 3, 4, 5})
    void createRoundTest(int finalRound) {
        Round round = Round.from(finalRound);
        int firstRound = 0;

        assertThat(round.currentRound()).isEqualTo(firstRound);
    }

    @ParameterizedTest
    @DisplayName("0이하의 라운드를 입력하면 예외 발생")
    @ValueSource(ints = {0, -1, -2, -3})
    void createRoundExceptionTest(int value) {
        assertThatThrownBy(() -> Round.from(value)).isInstanceOf(RoundException.class);
    }

}