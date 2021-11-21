package step3;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarTest {
    RacingCar racingCar = new RacingCar();

    @Test
    void getRandomNumber() {
        int expect = racingCar.getRandomNumber();
        assertThat(expect).isBetween(0, 9);
    }

    @ParameterizedTest()
    @CsvSource({"1, false", "4, false", "7, true"})
    void isMove(int number, boolean expect) {
        boolean result = racingCar.isMove(number);
        assertThat(result).isEqualTo(expect);
    }

    @Test
    void move() {
        int before = racingCar.getDistance();
        racingCar.move();
        int after = racingCar.getDistance();
        assertThat(before+1).isEqualTo(after);
    }


}