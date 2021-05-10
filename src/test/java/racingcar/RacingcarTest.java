package racingcar;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class RacingcarTest {
    RacingWinner racingWinner = new RacingWinner();
    RacingCarGame racingCarGame = new RacingCarGame();

    @ParameterizedTest
    @ValueSource(strings = {"gyubin", "sangkoo", "kyeonghwan"})
    void nameCheckTest(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new RacingCar(input);
        });
    }

    @Test
    void moveTest() {
        assertThat(racingCarGame.moveOrNot(4)).isEqualTo("-");
    }

    @Test
    void stopTest() {
        assertThat(racingCarGame.moveOrNot(3)).isEqualTo("");
    }

    @Test
    void winnerTest() {
        String[] carNameArr = {"gb : ---", "sk : --", "kh : -"};
        assertThat(racingWinner.selectWinner(carNameArr)).contains("gb : ---");
    }
}
