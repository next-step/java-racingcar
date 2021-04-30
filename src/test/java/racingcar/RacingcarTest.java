package racingcar;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class RacingcarTest {

    RacingCar racingCar = new RacingCar();
    RaceFunction raceFunction = new RaceFunction();

    @ParameterizedTest
    @ValueSource(strings = {"gyubin", "sangkoo", "kyeonghwan"})
    void nameCheckTest(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            racingCar.nameCheck(input);
        });
    }

    @Test
    void carNameUnionTest() {
        String carName = "gyubin,sangkoo,kyeonghwan";
        String[] carNameArr = racingCar.unionNameColon(carName);
        assertThat(carNameArr[0]).isEqualTo("gyubin : ");
        assertThat(carNameArr[1]).isEqualTo("sangkoo : ");
        assertThat(carNameArr[2]).isEqualTo("kyeonghwan : ");
    }

    @Test
    void moveTest() {
        assertThat(racingCar.condition(4)).isEqualTo("-");
    }

    @Test
    void stopTest() {
        assertThat(racingCar.condition(3)).isEqualTo("");
    }

    @Test
    void winnerTest() {
        String[] carNameArr = {"gb : ---", "sk : --", "kh : -"};
        assertThat(raceFunction.selectWinner(carNameArr)).contains("gb : ---");
    }
}
