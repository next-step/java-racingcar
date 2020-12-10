package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.rule.FixedRacingRule;
import racingcar.rule.RacingRule;
import racingcar.rule.RandomRacingRule;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarDriverTest {


    @ParameterizedTest
    @CsvSource(value = {"3,0", "4,1", "9,1", "0,0"})
    @DisplayName("주어진 숫자에 맞게 자동차가 진행했는지 거리를 테스트")
    public void moveForwardAll(String input, String expected) {
        // given
        FixedRacingRule racingRule = new FixedRacingRule(Integer.parseInt(input));
        RacingCarDriver racingCarDriver = new RacingCarDriver(1);

        // when
        racingCarDriver.moveForwardAll(racingRule);
        Integer distance = racingCarDriver.getNowDistance().get(0);

        // then
        assertThat(distance).isEqualTo(Integer.parseInt(expected));
    }
}
