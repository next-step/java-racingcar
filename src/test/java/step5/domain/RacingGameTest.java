package step5.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step5.domain.stretagy.MovingStrategy;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {

    @Test
    @DisplayName("우승자가 유일한 경우")
    public void singleWinnerTest() {
        RacingGame.setUp("pobi,crong,honux", new FirstCarWinsStrategy());
        RacingGame.race();

        List<String> winners = RacingGame.getWinners();

        assertThat(winners).hasSize(1);
        assertThat(winners).containsExactlyElementsOf(Arrays.asList("pobi"));
    }

    @Test
    @DisplayName("우승자가 여럿일 경우")
    public void manyWinnerTest() {
        RacingGame.setUp("pobi,crong,honux", new FirstCarLosesStrategy());
        RacingGame.race();

        List<String> winners = RacingGame.getWinners();

        assertThat(winners).hasSize(2);
        assertThat(winners).containsExactlyElementsOf(Arrays.asList("crong", "honux"));
    }

    private static class FirstCarWinsStrategy implements MovingStrategy {
        private boolean flag = true;

        @Override
        public boolean goOrStop() {
            if (flag) {
                flag = false;
                return true;
            }
            return false;
        }
    }

    private static class FirstCarLosesStrategy implements MovingStrategy {
        private boolean flag = true;

        @Override
        public boolean goOrStop() {
            if (flag) {
                flag = false;
                return false;
            }
            return true;
        }
    }

}