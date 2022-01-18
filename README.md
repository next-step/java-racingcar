# 자동차 경주 게임
## 기능 목록
- [ ] 문자열의 사칙연산을 수행한다. calculator.domain.Calculator#calculate()
  - [X] 문자열은 공백을 기준으로 분리한다. StringUtils#splitExpression()
  - [X] 빈 문자열 혹 올바른 사칙연산 문자열만 들어올 수 있다. calculator.domain.Calculator#validateIdleExpression()
  - [X] 문자열에는 숫자와 사칙연산 기호만 들어올 수 있다. calculator.domain.Calculator#validateOperand()
- [X] 사칙연산은 덧셈, 뺄셈, 나눗셈, 곱셈이 가능하다 calculator.domain.Calculator#validateQuery()
    - [X] 사칙연산의 우선순위는 무시된다.
- [ ] 사칙연산의 결과를 출력한다. ResultView#result()

## 기능 요구 사항
- [ ] 사용자가 입력한 문자열 값에 따라 사칙 연산을 수행할 수 있는 계산기를 구현해야 한다.
- [X] 문자열 계산기는 사칙 연산의 계산 우선순위가 아닌 입력 값에 따라 계산 순서가 결정된다. 즉, 수학에서는 곱셈, 나눗셈이 덧셈, 뺄셈 보다 먼저 계산해야 하지만 이를 무시한다.
- [X] 예를 들어 "2 + 3 * 4 / 2"와 같은 문자열을 입력할 경우 2 + 3 * 4 / 2 실행 결과인 10을 출력해야 한다.