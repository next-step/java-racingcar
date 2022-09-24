package racing;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

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
        Assertions.assertThat(RacingCar.isFourOrMore(input)).isEqualTo(result);
    }
}
