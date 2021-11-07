package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * 문자열 사칙 연산 계산기 구현
 * - 이번 미션의 핵심은 내가 구현하는 코드에 단위 테스트를 추가하는 경험을 하는 것이다.
 * - 모든 예외 상황을 처리하기 위해 너무 복잡하게 접근하지 않아도 된다.
 *
 * 기능 요구사항
 * - 사용자가 입력한 문자열 값에 따라 사칙연산을 수행할 수 있는 계산기를 구현해야 한다.
 * - 입력 문자열의 숫자와 사칙 연산 사이에는 반드시 빈 공백 문자열이 있다고 가정한다.
 * - 나눗셈의 경우 결과 값을 정수로 떨어지는 값으로 한정한다.
 * - 문자열 계산기는 사칙연산의 계산 우선순위가 아닌 입력 값에 따라 계산 순서가 결정된다. 즉, 수학에서는 곱셈, 나눗셈이 덧셈, 뺄셈 보다 먼저 계산해야 하지만 이를 무시한다.
 * - 예를 들어 2 + 3 * 4 / 2와 같은 문자열을 입력할 경우 2 + 3 * 4 / 2 실행 결과인 10을 출력해야 한다.
 *
 * 프로그래밍 요구사항
 * - 메소드가 너무 많은 일을 하지 않도록 분리하기 위해 노력해 본다.
 *
 * 기능 분리 힌트
 * - 테스트할 수 있는 단위로 나누어 구현 목록을 만든다.
 * - 덧셈, 뺄셈, 곱셈, 나눗셈
 * - 입력 값이 null이거나 빈 공백 문자일 경우 IllegalArgumentException throw
 * - 사칙연산 기호가 아닌 경우 IllegalArgumentException throw
 * - 사칙 연산을 모두 포함하는 기능 구현
 * - 공백 문자열을 빈 공백 문자로 분리하려면 String 클래스의 split(" ") 메소드를 활용한다.
 * - 반복적인 패턴을 찾아 반복문으로 구현한다.
 *
 * JUnit, AssertJ 구현 힌트
 * - Exception 구현 힌트
 * - AssertJ Exception Assertions 문서 참고
 * - https://www.baeldung.com/assertj-exception-assertion
 *
 * 자주 발생하는 Exception의 경우 Exception별 메서드 제공하고 있음
 * - assertThatIllegalArgumentException()
 * - assertThatIllegalStateException()
 * - assertThatIOException()
 * - assertThatNullPointerException()
 *
 * 테스트 데이터 전달
 * - Guide to JUnit 5 Parameterized Tests
 * - https://www.baeldung.com/parameterized-tests-junit-5
 */
public class CalculatorTest {
    // 가장 작은 단위부터 연습 (복잡도 낮게)
    // 처음에는 클래스 매서드로 생각
    // TDD 사이클에서는 컴파일 에러가 날수밖에 없음
    // 실패한 테스트 생성 -> 컴파일 에러 잡기
    // 기능 목록(=to-do list) 만들기 -> 테스트 케이스와 같음
    // 기능 목록을 잘 만드려면, 요구사항 분석을 잘해야 함
    // 객체를 단위로 비교할 것 -> 객체 지향적 프로그래밍 방법 
    // 프리머티브 타입보다는 객체로 들고 다닐 것
    // eqauls()와 hashcode() 메서드가 가장 마지막에 위치
    // 극단적인 연습 : 리턴값, 파라미터를 객체로 이동
    // 각각의 인자가 객체가 될 후보
    
    // 1. 들여쓰기는 한단계만 사용
    // 2. else 예약어는 쓰지 않음
    // 3. 모든 원시값과 문자열을 포장
    @Test
    public void 덧셈(){
        int result = Calculator.calculate2("1 + 2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void 뺄셈(){
        int result = Calculator.calculate2("3 - 2");
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void 곱셈(){
        int result = Calculator.calculate2("3 * 2");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void 나눗셈(){
        int result = Calculator.calculate2("4 / 2");
        assertThat(result).isEqualTo(2);

        assertThatThrownBy(() -> {
            Calculator.calculate("4 / 0");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
