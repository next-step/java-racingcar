package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RacingCarTest {

    @DisplayName("0에서 9사이의 random 값을 구한다.")
    @Test
    void getRandomNumber() {
        //given
        RacingCar racingCar = new RacingCar();

        //when
        int randomNumber = racingCar.getRandomNumber();

        //then
        assertThat(randomNumber).isBetween(0, 9);
    }
}
