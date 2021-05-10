package racingcar;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class RacingcarTest {
    RacingCarGame racingCarGame = new RacingCarGame();

    @ParameterizedTest
    @ValueSource(strings = {"Faker", "Uzi", "LWX"})
    void nameCheckTest(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new RacingCar(input);
        });
    }

    @Test
    void moveTest() {
        assertThat(moveOrNot(4)).isEqualTo("-");
    }

    @Test
    void stopTest() {
        assertThat(moveOrNot(3)).isEqualTo("");
    }

    @Test
    void winnerTest() {
        assertThat(racingWinner.selectWinner(carNameArr)).contains("gb : ---");
    }
}
