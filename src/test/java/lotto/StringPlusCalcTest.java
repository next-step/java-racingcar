package lotto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringPlusCalcTest {

    @ParameterizedTest
    @ValueSource(strings = {"1,2,-4", "-2", "r,a,b"})
    void create(String entered) {
       assertThatThrownBy(() -> {
           new StringPlusCalc(entered);
        }).isInstanceOf(RuntimeException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3", "1,2:3", "//;\n1;2;3"})
    public void customDelimiter(String entered) {
        StringPlusCalc stringPlusCalc = new StringPlusCalc(entered);
        int result = stringPlusCalc.sum();
        assertThat(result).isEqualTo(6);
    }

    @ParameterizedTest
    @CsvSource(value = {",", "''"})
    public void userEnteredOfNullAndEmpty(String entered) {
        StringPlusCalc stringPlusCalc = new StringPlusCalc(entered);
        int sum = stringPlusCalc.sum();
        assertThat(sum).isEqualTo(0);
    }

    @Test
    public void userEnteredOneNumber() {
        StringPlusCalc stringPlusCalc = new StringPlusCalc("3");
        int sum = stringPlusCalc.sum();
        assertThat(sum).isEqualTo(3);
    }
}