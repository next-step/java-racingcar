package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class RacingGameCoreTest {
    @Test
    void 정적_팩토리_테스트() throws Exception {
        // given
        Class<RacingGameCore> expected = RacingGameCore.class;
        int carCount = 3;
        int stageCount = 3;

        // when
        RacingGameCore game = RacingGameCore.of(carCount, stageCount);

        // then
        Assertions.assertThat(game).isNotNull().isInstanceOf(expected);
    }

    @Test
    void 게임_테스트() throws Exception {
        // given
        int carCount = 3;
        int stageCount = 3;
        int expected = new StringBuilder()
                .append("").append("\n")
                .append("").append("\n")
                .append("").append("\n")
                .toString()
                .length();

        // when
        int actual = RacingGameCore.of(carCount, stageCount)
                .run()
                .length();

        // then
        Assertions.assertThat(actual).isGreaterThan(expected);
    }
}