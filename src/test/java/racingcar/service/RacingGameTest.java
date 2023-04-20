package racingcar.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class RacingGameTest {

    @Nested
    @DisplayName("이름 분리 관련 테스트")
    class split{
        @Test
        @DisplayName("이름 분리 통과")
        void split () {
            RacingGame racingGame = new RacingGame("pobi,crong,honux", new MoveRandomStrategy());

            assertThat(racingGame.getRacingCars().getCars()).map(Car::getName).containsExactly("pobi", "crong", "honux");
        }

        @Test
        @DisplayName("참가한 자동차가 없을 경우")
        void splitExceptionNoPlayer() {
            assertThatThrownBy(()-> { RacingGame racingCar = new RacingGame("", new MoveRandomStrategy()); })
                    .isInstanceOf(RuntimeException.class).hasMessageContaining("player zero");
        }

    }
}
