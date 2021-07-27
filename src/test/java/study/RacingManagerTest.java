package study;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;


public class RacingManagerTest {

    RacingManager racingManager = new RacingManager();

    @Test
    public void getRandomNumberTest() {
        int randomNumber = racingManager.getRandomNumber();
        assertThat(randomNumber).isGreaterThanOrEqualTo(0).isLessThanOrEqualTo(9);
    }

    @ParameterizedTest
    @CsvSource(value = {"3,false", "9,true"})
    public void canMoveCarTest(int randomNumber, boolean result) {
        assertThat(racingManager.canMoveCar(randomNumber)).isEqualTo(result);
    }

}
