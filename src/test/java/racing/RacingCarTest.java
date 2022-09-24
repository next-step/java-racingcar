package racing;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

public class RacingCarTest {

    @Test
    void getRandomNum() {
        assertThat(RacingCar.getRandomNum())
                .isGreaterThanOrEqualTo(0)
                .isLessThanOrEqualTo(9);
    }

    @ParameterizedTest(name = "{0}가 4 이상인 지 체크")
    @CsvSource(value = {"3:false","4:true","5:true"}, delimiter = ':')
    void checkNumberSize(int input, Boolean result) {
        assertThat(RacingCar.isFourOrMore(input)).isEqualTo(result);
    }

    @ParameterizedTest(name = "{0}가 4 이상이면 +1")
    @CsvSource(value = {"3:4","4:5"}, delimiter = ':')
    void plusCount(int input, int result) {
        assertThat(RacingCar.plusCount(4,input)).isEqualTo(result);
    }

}
