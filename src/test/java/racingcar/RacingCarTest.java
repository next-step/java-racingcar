package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class RacingCarTest {

    @Test
    void 랜덤값_4_이상_전진(){
        int result = RacingCar.moveForward(4);
        assertThat(result).isEqualTo(1);
        result = RacingCar.moveForward(1);
        assertThat(result).isEqualTo(0);
    }

    @Test
    void 랜덤값_추출(){
        int random = RacingCar.getRandomValue();
        assertThat(random).isBetween(0,9);
    }
}
