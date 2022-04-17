package racingcar.controller;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class RacingGameTest {

    @Nested
    class end_메서드는 {

        @Nested
        class 종료된_게임일경우 {

            @Test
            void true를_리턴한다() {
                RacingGame endedRacingGame = new RacingGame(0);

                boolean actual = endedRacingGame.end();

                assertThat(actual).isTrue();
            }
        }

        @Nested
        class 종료되지않은_게임일경우 {

            @Test
            void false를_리턴한다() {
                RacingGame notEndedRacingGame = new RacingGame(5);

                boolean actual = notEndedRacingGame.end();

                assertThat(actual).isFalse();
            }
        }
    }
}
