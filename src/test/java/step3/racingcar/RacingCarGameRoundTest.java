package step3.racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingCarGameRoundTest {

    @Test
    @DisplayName("RacingCarGame All Test")
    void givenRandomSeed_whenRoundStart_thenRoundShowResult() {
        // given
        int numberOfCars = 3;
        int randomSeed = 3;

        // when
        RacingCar[] cars = new RacingCar[numberOfCars];
        for (int i = 0; i < numberOfCars; i++) {
            int no = i + 1;
            cars[i] = new RacingCar(no, randomSeed);
        }

        RacingCarGameRound round = new RacingCarGameRound(1, cars);
        for (int i = 0; i < 5; i++) {
            round.start();
        }

        // then
        assertThat(cars[0].roundResult()).isEqualTo(RacingCarResult.GO);
        assertThat(cars[0].roundResult()).isEqualTo(RacingCarResult.GO);
    }

}
