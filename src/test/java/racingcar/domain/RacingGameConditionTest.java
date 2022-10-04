package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameConditionTest {

    @DisplayName("자동차 이름 반환 테스트")
    @Test
    void getRacingCarNames() {
        // given
        String racingCarNamesJointComma = "woody.mjin,beans.go,isla.moon";
        int gameTurnCount = 5;

        RacingGameCondition racingGameCondition = new RacingGameCondition(racingCarNamesJointComma, gameTurnCount);

        // when
        List<String> result = racingGameCondition.getRacingCarNames();

        // then
        assertThat(result).hasSize(3)
                          .containsExactly("woody.mjin", "beans.go", "isla.moon");
    }

    @DisplayName("자동차 경주 진행 턴 반환 테스트")
    @Test
    void getGameTurnCount() {
        // given
        String racingCarNamesJointComma = "woody.mjin,beans.go,isla.moon";
        int gameTurnCount = 5;

        RacingGameCondition racingGameCondition = new RacingGameCondition(racingCarNamesJointComma, gameTurnCount);

        // when
        int result = racingGameCondition.getGameTurnCount();

        // then
        assertThat(result).isEqualTo(5);
    }
}