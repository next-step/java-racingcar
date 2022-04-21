package racingCar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class RandomNumberTest {

    @Test
    void 랜덤유효값확인(){
        RandomNumber randomNumber = new RandomNumber();
        Assertions.assertThat(randomNumber.validateRandomNumber()).isTrue();
    }
}
