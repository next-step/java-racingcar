package racingcar;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class RacingcarTest {
    RacingCar racingCar = new RacingCar();
    Winner winner = new Winner();

    @ParameterizedTest
    @ValueSource(strings = {"gyubin", "sangkoo", "kyeonghwan"})
    void nameCheckTest(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            racingCar.nameCheck(input);
        });
    }

    @Test
    void moveTest() {
        assertThat(racingCar.moveOrNot(4)).isEqualTo("-");
    }

    @Test
    void stopTest() {
        assertThat(racingCar.moveOrNot(3)).isEqualTo("");
    }

    @Test
    void winnerTest() {
        String[] carNameArr = {"gb : ---", "sk : --", "kh : -"};
        assertThat(winner.selectWinner(carNameArr)).contains("gb : ---");
    }
}
