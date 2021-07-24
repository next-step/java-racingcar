package stringCalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class OperationTest {

    @DisplayName("비연산자 예외 처리 단위 테스트")
    @ParameterizedTest // given
    @ValueSource(strings = {"&", "r", "!", "@", "#"})
    void nonOperatorTest(String nonOperator){
        // when, then
        assertThatThrownBy(() -> { FourOperation.of(nonOperator);}).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("사칙연산 기호가 아닌 문자");
    }

    @DisplayName("덧셈 메서드 단위 테스트")
    @ParameterizedTest
    @CsvSource({"1,2,3", "3,4,7", "-1,3,2"}) // given
    void sumTest(String a, String b, String result) {
        // when
        String answer = FourOperation.PLUS.apply(a,b);
        // then
        assertThat(answer).isEqualTo(result);
    }

    @DisplayName("뺄셈 메서드 단위 테스트")
    @ParameterizedTest
    @CsvSource({"3,2,1", "7,4,3", "2,3,-1"}) // given
    void diffTest(String a, String b, String result) {
        // when
        String answer = FourOperation.MINUS.apply(a,b);
        // then
        assertThat(answer).isEqualTo(result);
    }

    @DisplayName("곱셈 메서드 단위 테스트")
    @ParameterizedTest
    @CsvSource({"3,2,6", "7,4,28", "-1,3,-3"}) // given
    void multTest(String a, String b, String result) {
        // when
        String answer = FourOperation.TIMES.apply(a,b);
        // then
        assertThat(answer).isEqualTo(result);
    }

    @DisplayName("나눗셈 메서드 단위 테스트")
    @ParameterizedTest
    @CsvSource({"3,2,1", "28,4,7", "3,-3,-1"}) // given
    void divTest(String a, String b, String result) {
        // when
        String answer = FourOperation.DIVIDE.apply(a,b);
        // then
        assertThat(answer).isEqualTo(result);
    }


}