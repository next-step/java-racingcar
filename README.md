# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## 기능 요구 사항
  - [X] 사용자 입력 값을 받는다. class console / readLine()
    - [X] 입력 값은 숫자, +, -, *, / 만 가능하다. validateNumber()
      - [X] 입력 값이 숫자가 아니면 IllegalArgumentException throw를 발생시킨다.
    - [X] 입력 값은 공백이 아닌 값만 가능하다. validateUserInputEmpty()
      - [X] 입력 값은 null, 빈 공백은 IllegalArgumentException throw를 발생시킨다.
    - [X] 기호는 사칙연산 기호만 가능하다. validateArithmetic()
      - [X] 사칙연산 기호가 아닌 경우 IllegalArgumentException throw를 발생시킨다.
    - [X] 0으로 나눌 수 없다. validateDivideZero()
      - [X] 0으로 나누는 경우, IllegalArgumentException throw를 발생시킨다.
    - [X] 숫자 결과를 출력한다. class console / printResult()
  - [X] 사칙 연산의 계산 우선순위가 아닌 입력 값에 따라 계산 순서가 결정된다. class calculator
    - [X] 덧셈 기호가 있는 경우 addNumbers()
    - [X] 뺄셈 기호가 있는 경우 subtractNumbers()
    - [X] 곱셈 기호가 있는 경우 multiplyNumbers()
    - [X] 나눗셈 기호가 있는 경우 divideNumbers()
    - [X] 연산의 결과를 업데이트 하는 메소드가 존재한다. calculateNumbers()
    - [X] 연산의 결과를 반환하는 메소드가 존재한다. getResult()
