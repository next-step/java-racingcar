package racingcar.application;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import racingcar.utils.Const;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("경주할 자동차의 목록과 진행상태에 관한 클래스")
class RacingGameTest {
    @ParameterizedTest
    @CsvSource(value = {"pobi,crong,honux=3"}, delimiter = '=')
    @DisplayName("경주할 자동자를 split로 분리한 후 명수가 맞는지 확인한다.")
    void splitComma(String inputCarNames, int expected) {
        RacingGame racingGame = new RacingGame(inputCarNames, Const.INITIAL_NUM);
        assertThat(racingGame.getRacingCars().size()).isEqualTo(expected);
    }

    @ParameterizedTest
    @NullSource
    @EmptySource
    @DisplayName("입력된 값이 null 값인지 체크")
    void existCarNames(String input) {
        assertThatThrownBy(() ->
                new RacingGame(input, Const.INITIAL_NUM)
        ).isInstanceOf(NullPointerException.class)
                .hasMessageContaining("이름을 입력해주세요.");
    }
}