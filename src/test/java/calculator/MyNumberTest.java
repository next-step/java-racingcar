package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MyNumberTest {
    @DisplayName("MyNumber 객체 생성시 String 과 int 모두 사용 가능하다.")
    @Test
    void create() {
        assertThat(new MyNumber("1")).isEqualTo(new MyNumber(1));
    }

    @DisplayName("MyNumber.plus 함수는 멤버 변수(number)에 더하기 연산을 수행하고 연산 결과를 새로운 MyNumber 객체로 반환한다.")
    @Test
    void plus() {
        MyNumber actual = new MyNumber("1").plus(new MyNumber(2));
        assertThat(actual).isEqualTo(new MyNumber(3));
    }

    @DisplayName("MyNumber.minus 함수는 멤버 변수(number)에 뺄셈 연산을 수행하고 연산 결과를 새로운 MyNumber 객체로 반환한다.")
    @Test
    void minus() {
        MyNumber actual = new MyNumber("2").minus(new MyNumber(1));
        assertThat(actual).isEqualTo(new MyNumber(1));
    }

    @DisplayName("MyNumber.multiple 함수는 멤버 변수(number)에 곱셈 연산을 수행하고 연산 결과를 새로운 MyNumber 객체로 반환한다.")
    @Test
    void multiple() {
        MyNumber actual = new MyNumber("1").multiple(new MyNumber(2));
        assertThat(actual).isEqualTo(new MyNumber(2));
    }

    @DisplayName("MyNumber.divideBy 함수는 멤버 변수(number)에 나눗셈 연산을 수행하고 연산 결과를 새로운 MyNumber 객체로 반환한다.")
    @Test
    void divideBy() {
        MyNumber actual = new MyNumber("4").divideBy(new MyNumber(2));
        assertThat(actual).isEqualTo(new MyNumber(2));
    }

}
