package racingcar.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Round;
import racingcar.domain.input.RoundCount;

import static org.assertj.core.api.Assertions.assertThat;

class InputRoundCountTest {

    @Test
    @DisplayName("문자열 숫자를 입력하면 문자열 숫자가 최종 라운드인 Round 가 반환된다.")
    void StringToInt() {
        RoundCount roundTwo = new RoundCount(2);
        assertThat(new InputRoundCount("2").toRound()).isEqualTo(new Round(roundTwo));
    }

}