package racingCar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class racingCarTest {

    @ParameterizedTest
    @DisplayName("입력값이 3이하일 경우 0(정지)을 반환하고, 4이상일 경우 1(전진)을 반환한다.")
    @CsvSource(value = {"0:0","1:0","2:0","3:0","4:1","5:1","6:1","7:1","8:1","9:1"}, delimiter = ':')
    public void 정지_또는_전진_조건_테스트(int input, int expected){
        assertThat(RacingCar.moveCar(input)).isEqualTo(expected);
    }

    @Test
    @DisplayName("0에서 9사이의 랜덤값을 반환한다.")
    public void 랜덤값_추출_0과_9사이_정수(){
        int random = RandomNumber.getRandom(10);
        assertThat(random).isBetween(0,9);
    }
}
