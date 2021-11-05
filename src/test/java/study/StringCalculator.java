package study;

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
public class StringCalculator {

}
