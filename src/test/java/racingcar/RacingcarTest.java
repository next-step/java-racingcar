package racingcar;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class RacingcarTest {

    RacingCar racingCar = new RacingCar();
    NonTestRacingCar nonTestRacingCar = new NonTestRacingCar();

    @ParameterizedTest
    @ValueSource(strings = {"gyubin", "sangkoo", "kyeonghwan"})
    void nameCheckTest(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            racingCar.nameCheck(input);
        });
    }

    @Test
    void carStringtoArrayTest() {
        String carName = "gyubin,sangkoo,kyeonghwan";
        String[] carNameArr = racingCar.carStringtoArray(carName);
        assertThat(carNameArr[0]).isEqualTo("gyubin : ");
        assertThat(carNameArr[1]).isEqualTo("sangkoo : ");
        assertThat(carNameArr[2]).isEqualTo("kyeonghwan : ");
    }

    @Test
    void moveTest(){
        assertThat(racingCar.moveOrNot(4)).isEqualTo("-");
    }

    @Test
    void stopTest(){
        assertThat(racingCar.moveOrNot(3)).isEqualTo("");
    }

    @Test
    void winnerTest(){
        String[] carNameArr = {"gb : ---", "sk : --", "kh : -"};
        assertThat(racingCar.selectWinner(carNameArr)).contains("gb : ---");
    }

}
