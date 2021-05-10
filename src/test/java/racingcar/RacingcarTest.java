package racingcar;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class RacingcarTest {
    RacingCarGame racingCarGame = new RacingCarGame();
    RacingCar racingCar= new RacingCar("aws");

    @ParameterizedTest
    @ValueSource(strings = {"Faker", "Uzi", "LWX"})
    void nameCheckTest(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new RacingCar(input);
        });
    }

    @Test
    void moveTest() {
        racingCar.moveOrNot(4);
        assertThat(racingCar.getPosition()).isEqualTo(1);
    }

    @Test
    void stopTest() {
        racingCar.moveOrNot(3);
        assertThat(racingCar.getPosition()).isEqualTo(0);
    }

//    @Test
//    void winnerTest() {
//        assertThat(racingWinner.selectWinner(carNameArr)).contains("gb : ---");
//    }
}
