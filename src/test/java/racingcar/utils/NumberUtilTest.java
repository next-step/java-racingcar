package racingcar.utils;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class NumberUtilTest {

    @Test
    void generateRandomNumber() {
        int randomNum = NumberUtil.generateRandomNumber();

        assertThat(randomNum).isInstanceOf(Integer.class);
        assertThat(randomNum).isGreaterThanOrEqualTo(0);
        assertThat(randomNum).isLessThanOrEqualTo(9);
    }

    @ParameterizedTest
    @CsvSource(value = {"4:true", "120:true", "2:false"}, delimiter = ':')
    void isPossibleToMove(int number, boolean result) {
        assertThat(NumberUtil.isPossibleToMove(number)).isEqualTo(result);
    }
}