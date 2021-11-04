package calculator;

import calculator.exception.DivideByZeroException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MyNumberTest {

    @Test
    @DisplayName("객체를 생성한다.")
    void 테스트_MyNumber_construct() {
        MyNumber number = new MyNumber("1");
        assertThat(number).isEqualTo(new MyNumber(1));
    }

    @Test
    @DisplayName("plus 메소드는 두 MyNumber 객체의 더하기 연산을 수행한 결과를 MyNumber 객체로 반환한다")
    void 테스트_plus() {
        MyNumber actual = new MyNumber("1").plus(new MyNumber("2"));
        assertThat(actual).isEqualTo(new MyNumber("3"));
    }

    @Test
    @DisplayName("minus 메소드는 두 MyNumber 객체의 빼기 연산을 수행한 결과를 MyNumber 객체로 반환한다")
    void 테스트_minus() {
        MyNumber actual = new MyNumber("3").minus(new MyNumber("2"));
        assertThat(actual).isEqualTo(new MyNumber("1"));
    }

    @Test
    @DisplayName("multiply 메소드는 두 MyNumber 객체의 곱하기 연산을 수행한 결과를 MyNumber 객체로 반환한다")
    void 테스트_multiply() {
        MyNumber actual = new MyNumber("3").multiply(new MyNumber("2"));
        assertThat(actual).isEqualTo(new MyNumber("6"));
    }

    @Test
    @DisplayName("divide 메소드는 두 MyNumber 객체의 나누기 연산을 수행한 결과를 MyNumber 객체로 반환한다")
    void 테스트_divide() {
        MyNumber actual = new MyNumber("4").divide(new MyNumber("2"));
        assertThat(actual).isEqualTo(new MyNumber("2"));
    }

    @Test
    @DisplayName("divide 메소드는 0으로 나누려고 할 때 IllegalArgumentException 예외가 발생한다")
    void 테스트_divide_DivideByZeroException() {
        assertThrows(DivideByZeroException.class, () -> {
            new MyNumber("4").divide(new MyNumber("0"));
        });
    }
}
