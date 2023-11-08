package racingCar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class racingCarTest {

    @Test
    @DisplayName("0에서 9사이의 랜덤값을 반환한다.")
    public void 랜덤값_추출_0과_9사이_정수(){
        int random = RandomNumber.getRandom(10);
        assertThat(random).isBetween(0,9);
    }
}
