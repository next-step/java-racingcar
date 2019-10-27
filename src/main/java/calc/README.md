# 문자열 사칙 연산 계산기 구현

## 기능 목록
* 덧셈 기능
* 뺼셈 기능
* 곱셈 기능
* 나눗셈 기능
* 문자열 입력 기능
  * 입력값이 null이거나 공백 문자일 경우, throw IllegalArgumentException
  * 사칙연산 기호가 아닌 경우, throw IllegalArgumentException

---
# 자동차 경주 게임 구현

## 기능 목록
* 주어진 횟수(n)동안 m대의 자동차는 전진/멈출 수 있다.
* 사용자로부터 n, m을 입력받는다.
  * n 또는 m 이 양수가 아니면, throw IllegalArgumentException
* 자동차의 전진 조건은 0~9 사이의 랜던 값을 구한 후 그 값이 4 이상일 경우이다.
* 경주가 끝나면 자동차의 상태를 화면에 출력한다. 