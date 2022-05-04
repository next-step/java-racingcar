package racingCar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class RandomNumberTest {
    @Test
    void 랜덤유효범위확인() {
        RandomNumber randomNumber = new RandomNumber();
        int temporaryRandomNumber = randomNumber.createRandomNumber();
        Assertions.assertThat(randomNumber.validateRandomNumber(temporaryRandomNumber)).isTrue();
    }
}
