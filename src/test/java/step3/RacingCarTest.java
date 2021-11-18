package step3;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarTest {

    @ParameterizedTest()
    @CsvSource({"1, false", "4, false", "7, true"})
    void isMove(int number, boolean expect) {
        //랜덤값인데 어떻게 테스트가 될지?
        RacingCar racingCar = new RacingCar();
        boolean result = racingCar.isMove(number);
        assertThat(result).isEqualTo(expect);
    }

    @Test
    void play() {
        RacingCar racingCar = new RacingCar();

    }
}