package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class RacingGameCoreTest {
    @Test
    void 정적_팩토리_테스트() throws Exception {
        // given
        Class<RacingGameCore> expected = RacingGameCore.class;
        String[] carNames = {"siro1", "siro2", "siro3"};
        int stageCount = 3;

        // when
        RacingGameCore game = RacingGameCore.of(carNames, stageCount);

        // then
        Assertions.assertThat(game).isNotNull().isInstanceOf(expected);
    }

    @Test
    void 게임_테스트() throws Exception {
        // given
        String[] carNames = {"siro1", "siro2", "siro3"};
        int stageCount = 3;
        int expected = new StringBuilder()
                .append("").append("\n")
                .append("").append("\n")
                .append("").append("\n")
                .toString()
                .length();

        // when
        int actual = RacingGameCore.of(carNames, stageCount)
                                   .run()
                                   .length();

        // then
        Assertions.assertThat(actual).isGreaterThan(expected);
    }
}
