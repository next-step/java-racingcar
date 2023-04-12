package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringCalculatorTest {

    StringCalculator stringCalculator = null;

    @BeforeEach
    void StringCalculatorTest(){
        stringCalculator = new StringCalculator();
    }

    @Test
    @DisplayName("문자열이 빈 문자열인지 체크")
    void stringNullTest() {
        boolean actual = stringCalculator.checkStrNull("");
        assertThat(actual).isEqualTo(true);
    }

    @Test
    @DisplayName("커스텀 구분자/기본 구분자 지정 테스트")
    void testDelimeter(){
        assertThat(stringCalculator.getDelimeter("1,2")).isEqualTo("[,:-]");
        assertThat(stringCalculator.getDelimeter("1,2,3")).isEqualTo("[,:-]");
        assertThat(stringCalculator.getDelimeter("1,2:3")).isEqualTo("[,:-]");
        assertThat(stringCalculator.getDelimeter("//;\n1;2;3")).isEqualTo(";");
    }

    @Test
    @DisplayName("구분자 통한 실제 숫자 문자열 구하기")
    void testFinData(){
        assertThat(stringCalculator.getNumberData("1,2,3")).isEqualTo("1,2,3");
        assertThat(stringCalculator.getNumberData("1,2:3")).isEqualTo("1,2:3");
        assertThat(stringCalculator.getNumberData("//;\n1;2;3")).isEqualTo("1;2;3");
    }

    @Test
    @DisplayName("구분자를 통한 숫자 리스트 구하기")
    void testSplit(){
        assertThat(stringCalculator.doSplit("1,2,3", "[,:-]")).contains("1", "2", "3");
        assertThat(stringCalculator.doSplit("1,2:3", "[,:-]")).contains("1", "2", "3");
        assertThat(stringCalculator.doSplit("1;2;3", ";")).contains("1", "2", "3");
    }

    @Test
    @DisplayName("숫자인지, 음수인지 체크")
    void testNumberValidation(){
        assertThatExceptionOfType(RuntimeException.class).isThrownBy(() -> {
            assertThat(stringCalculator.isNumbers(new String[]{"-1", "2", "3"}));
        });
        assertThatExceptionOfType(RuntimeException.class).isThrownBy(() -> {
            assertThat(stringCalculator.isNumbers(new String[]{"1", "2", "-3"}));
        });
        assertThatExceptionOfType(RuntimeException.class).isThrownBy(() -> {
            assertThat(stringCalculator.isNumbers(new String[]{"1", "2", "-"}));
        });
    }

    @Test
    @DisplayName("각 숫자 합 테스트")
    void testSum(){
        assertThat(stringCalculator.sumNumber(new String[]{"1", "2", "3"})).isEqualTo(6);
    }

    @Test
    @DisplayName("최종 테스트")
    void testFinal(){
        assertThat(stringCalculator.calculate("")).isEqualTo(0);
        assertThat(stringCalculator.calculate(null)).isEqualTo(0);
        assertThat(stringCalculator.calculate("1")).isEqualTo(1);
        assertThat(stringCalculator.calculate("1,2")).isEqualTo(3);
        assertThat(stringCalculator.calculate("1,2,3")).isEqualTo(6);
        assertThat(stringCalculator.calculate("1,2:3")).isEqualTo(6);
        assertThat(stringCalculator.calculate("//;\n1;2;3")).isEqualTo(6);
    }
}
