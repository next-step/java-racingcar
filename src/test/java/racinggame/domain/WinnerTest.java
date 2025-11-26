package racinggame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinnerTest {

    @Test
    @DisplayName("우승자가 여러 명일 경우 모두 출력한다")
    void multipleWinnersAreAllAnnounced() {
        Car pobi = new Car("pobi", 5);
        Car crong = new Car("crong", 5);
        Car honux = new Car("honux", 3);

        RacingGame racingGame = new RacingGame(List.of(pobi, crong, honux), 1);


        assertThat(racingGame.findWinners().getNames()).containsExactlyInAnyOrder("pobi", "crong");
    }

}
