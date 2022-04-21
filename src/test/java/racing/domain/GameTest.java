package racing.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameTest {

    @DisplayName("경기를 N번 진행한다.")
    @Test
    void proceedRound() {
        final Game game = new Game(NumberOfRound.of(5));
        game.equipRacingCar(NumberOfCars.of(3));

        int count = 0;
        while (game.isLeftRound()) {
            game.proceedRound();
            count++;
        }

        assertThat(count).isEqualTo(5);
    }

}
