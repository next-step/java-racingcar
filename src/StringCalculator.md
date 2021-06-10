# 문자열 계산기

## 기능 요구 사항
- 사용자가 입력한 문자열 값에 따라 사칙 연산을 수행할 수 있는 계산기를 구현해야 한다.
- 문자열 계산기는 사칙 연산의 계산 우선순위가 아닌 입력 값에 따라 계산 순서가 결정된다. 즉, 수학에서는 곱셈, 나눗셈이 덧셈, 뺄셈 보다 먼저 계산해야 하지만 이를 무시한다.
- 예를 들어 "2 + 3 * 4 / 2"와 같은 문자열을 입력할 경우 2 + 3 * 4 / 2 실행 결과인 10을 출력해야 한다.

## 프로그래밍 요구 사항
- 자바 코드 컨벤션을 지키면서 프로그래밍한다.
  - 기본적으로 [Google Java Style Guide](https://google.github.io/styleguide/javaguide.html) 을 원칙으로 한다.
  - 단, 들여쓰기는 '2 spaces'가 아닌 '4 spaces'로 한다.
- indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
  - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
  - 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메소드)를 분리하면 된다.
- 3항 연산자를 쓰지 않는다.
- 함수(또는 메소드)가 한 가지 일만 하도록 최대한 작게 만들어라.

## String Calculator 구현 기능 목록
- [x] 사용자가 수식을 문자열로 입력한다.
- [x] 입력값이 빈 문자열이거나 null 이라면 IllegalArgumentException을 발생시킨다.
- [x] 그렇지 않다면 공백을 기준으로 문자열을 쪼개서 String 배열에 저장한다.
- [x] 수식의 첫번째 숫자를 result 변수에 저장한다.
- [x] 수식의 첫번째 연산자에 따라 첫번째 숫자와 두번째 숫자를 계산한다.
- [x] 연산자 자리에 + , - , * , / 외의 문자가 입력되었다면 IllegalArgumentException을 발생시킨다.
- [x] 0 으로 나눈다면 RuntimeException을 발생시킨다.
- [x] 앞서 계산한 값은 result 변수에 저장하여 그 다음 숫자와 다시 계산한다.

### stringcalculator.StringCalculator 의 기능
- BLANK
- SEPARATOR
- `StringCalculator#checkBlank` : 빈 칸 확인
- `StringCalculator#splitBySeparator` : 문자열을 구분자로 분리
- `StringCalculator#calculateSplitstring` : 구분된 문자열 계산
- `StringCalculator#calculateTwoNumbers` : 두 숫자 계산
- `StringCalculator#add` : 더하기
- `StringCalculator#subtract` : 빼기
- `StringCalculator#multiply` : 곱하기
- `StringCalculator#divide` : 나누기

### stringcalculator.StringCalculatorView 의 기능
- (Scanner) scanner
- `StringCalculatorView#inputString` : 문자열 입력
- `StringCalculatorView#outputResult` : 결과 출력
