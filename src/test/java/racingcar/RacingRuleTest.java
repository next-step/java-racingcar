package racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RacingRuleTest {

    @Test
    @DisplayName("시도 횟수를 입력받은 레이싱 룰을 생성한다.")
    void createRacingGame() {
        //given
        int round = 3;

        //when
        RacingRule racingRule = new RacingRule(round);

        //then
        assertThat(racingRule.getRound()).isEqualTo(round);
    }

    @ParameterizedTest
    @CsvSource(value = {"3:false", "4:true", "5:true"}, delimiter = ':')
    @DisplayName("4 이상이면 움직일 수 있다.")
    void isMovable(int num, boolean expected) {
        //given
        RacingRule racingRule = new RacingRule(3);

        //when & then
        assertThat(racingRule.isMovable(num)).isEqualTo(expected);
    }
}
