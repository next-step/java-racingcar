package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringCalculatorTest {

    private StringCalculator stringCalculator;

    @BeforeEach
    void setUp(){
        stringCalculator = new StringCalculator();
    }

    @Test
    @DisplayName("빈 문자열 이거나 null 이면 0 반환")
    void emptyStringOrNull(){
        assertThat(stringCalculator.addString(null)).isEqualTo(0);
        assertThat(stringCalculator.addString("")).isEqualTo(0);
    }

    @Test
    @DisplayName("숫자 하나를 문자열로 입력시 해당 숫자 반환")
    void convertStringToInteger(){
        assertThat(stringCalculator.addString("1")).isEqualTo(1);
        assertThat(stringCalculator.addString("5")).isEqualTo(5);
    }

    @Test
    @DisplayName("컴마를 구분자로 숫자의 합을 반환")
    void commaDelimiter(){
        assertThat(stringCalculator.addString("1,2")).isEqualTo(3);
        assertThat(stringCalculator.addString("1,2,3")).isEqualTo(6);
    }

    @Test
    @DisplayName("콜론을 구분자로 숫자의 합을 반환")
    void colonDelimiter(){
        assertThat(stringCalculator.addString("1:2")).isEqualTo(3);
        assertThat(stringCalculator.addString("1:2:3")).isEqualTo(6);
    }

    @Test
    @DisplayName("커스텀 구분자로 숫자의 합을 반환")
    void customDelimiter(){
        assertThat(stringCalculator.addString("//#\n1#2")).isEqualTo(3);
        assertThat(stringCalculator.addString("//#\n1#2#3")).isEqualTo(6);
    }

    @Test
    @DisplayName("음수가 있는 경우 RuntimeException")
    void validateNegative(){
        assertThatThrownBy(()->{
            stringCalculator.addString("1,-2");
        }).isInstanceOf(RuntimeException.class);

        assertThatThrownBy(()->{
            stringCalculator.addString("//#\n1#2#-3");
        }).isInstanceOf(RuntimeException.class);
    }

}
