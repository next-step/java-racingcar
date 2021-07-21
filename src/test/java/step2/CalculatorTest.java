package step2;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
//import static org.junit.jupiter.api.Assertions.assert;

class CalculatorTest {

//    기능 분리 힌트
//    테스트할 수 있는 단위로 나누어 구현 목록을 만든다.
//    덧셈
//    뺄셈
//    곱셈
//    나눗셈
//    입력 값이 null이거나 빈 공백 문자일 경우 IllegalArgumentException throw
//    사칙연산 기호가 아닌 경우 IllegalArgumentException throw
//    사칙 연산을 모두 포함하는 기능 구현
//    공백 문자열을 빈 공백 문자로 분리하려면 String 클래스의 split(" ") 메소드를 활용한다.
//    반복적인 패턴을 찾아 반복문으로 구현한다.
    static Calculator cal;
    @BeforeAll
    static void makeCalculator(){
        cal = new Calculator();
    }

    @Test
    void create() {
        assertThat(cal.calculate("1 + 2 / 3")).isEqualTo(1);
    }

    @DisplayName("맞는 수식 계산 확인")
    @Test
    void calculateCollect() {
        int result = cal.calculate("2 + 2 * 3");
        assertThat(result).isEqualTo(12);
    }

    @DisplayName("잘못된 수식1")
    @Test
    void errorTest() {
        assertThatIllegalArgumentException().isThrownBy(
                () -> cal.calculate("1 + 3 +")
        ).withMessageContaining("잘못된 수식");
    }

    @DisplayName("잘못된 수식2")
    @Test
    void errTest2() {
        assertThatIllegalArgumentException().isThrownBy(
                () -> cal.calculate("1 3 +")
        ).withMessageContaining("올바른 연산자가 아닙니다");
    }

    @DisplayName("생성에러 (공백 입력)")
    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    void constructorError(String input) {
        assertThatIllegalArgumentException().isThrownBy(
                () -> cal.calculate(input)
        ).withMessageContaining("공백 or null");
    }

    @DisplayName("NULL 입력")
    @Test
    void inputNull() {
        assertThatIllegalArgumentException().isThrownBy(
                () -> cal.calculate(null)
        ).withMessageContaining("공백 or null");
    }

    @DisplayName("올바른 수식")
    @ParameterizedTest
    @CsvSource(value = {"1 + 1:2", "1 - 1:0", "2 * 3:6", "4 / 3:1"}, delimiter = ':')
    void calculateTest(String input, String expect) {
        assertThat(cal.calculate(input)).isEqualTo(Integer.valueOf(expect));
    }

    @DisplayName("숫자 하나만 입력")
    @Test
    void inputOnlyOne() {
        assertThat(cal.calculate("1")).isEqualTo(1);
    }

    @DisplayName("연산자 하나만 입력")
    @Test
    void inputOnlyOneExpress() {
        assertThatIllegalArgumentException().isThrownBy(
                () -> cal.calculate("+")
        ).withMessageContaining("숫자가 아닙니다.");
    }
}