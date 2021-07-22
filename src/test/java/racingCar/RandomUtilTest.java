package racingCar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RandomUtilTest {

    @DisplayName("0부터 9의 숫자 중 랜덤 값")
    @Test
    void getRandom(){
        assertThat(RandomUtil.getNumber()).isBetween(0, 9);
    }
}