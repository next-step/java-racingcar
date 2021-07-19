package step2;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
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

    @Test
    void create(){
        Calculator cal = new Calculator("1 + 2 / 3");
    }


}