package stringCalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;


class StringCalculatorTest {

    @DisplayName("입력 및 연산 메서드 단위 테스트")
    @ParameterizedTest
    @CsvSource({"1 + 3 - 2 * 5 / 2,5", "3 - 4 + 5 * 2 / 3, 2"}) // given
    void calculateTest(String problem, String result){
        // when
        StringCalculator stringCalculator = new StringCalculator();
        String answer = stringCalculator.calculate(problem);
        //then
        assertThat(answer).isEqualTo(result);
    }

    @Test
    @DisplayName("공백 문자 입력 예외 처리 단위 테스트")
    void emptyStringTest(){
        // given
        String problem = "";
        // when, then
        StringCalculator stringCalculator = new StringCalculator();
        assertThatThrownBy(() -> {
            stringCalculator.calculate(problem);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("공백 문자");
    }

}