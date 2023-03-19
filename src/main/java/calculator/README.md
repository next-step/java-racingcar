# 문자열 계산기
## 기능 요구사항
- [X] 입력한 문자열에 따라 사칙 연산을 수행
  - [X] 입력값이 null이거나 공백인 경우 IllegalArgumentException
- [X] 사칙연산은 +, -, *, /
  - [X] 사칙연산 기호가 아닌 경우 IllegalArgumentException
  - [X] 사칙연산의 피연산자가 숫자가 아닌 경우 IllegalException
- [X] 연산의 우선순위는 입력 순서에 따른다