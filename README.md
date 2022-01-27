# 자동차 경주 게임

## 진행 방법

* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정

* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)


# 📌 계산기
## 기능 요구 사항

사용자가 입력한 문자열 값에 따라 사칙 연산을 수행할 수 있는 계산기. 문자열 계산기는 사칙 연산의 계산 우선순위가 아닌 입력 값에 따라 계산 순서가 결정된다.
## 기능 구현 사항

- [x] 입력 받기 (Expression.getUserInput())
- [x] 연산 (Calculator)
    - [x] 덧셈(.add())
    - [x] 뺄셈(.sub())
    - [x] 곱셈(.mul())
    - [x] 나눗셈(.div())
- [x] 입력 검증 (Validator)
- [x] 입력 형식 (number op number op number ...) 검증
    - [x] 공백인지 ("", " ") -> IllegalArgumentException 
    - [x] split 후 짝수번째 -> 숫자. -> NumberFormatException
    - [x] split 후 홀수 번쨰 -> 연산자(+, - , *, /) -> InputMismatchException
- [x] 입력받은 식 파싱(ExpressionParser.parseExpression)
- [x] 파싱된 식 계산 (Calculator.evaluate)
  - [x] 앞에서부터 하나씩 연산(Calculator.calculate)
    - [x] 지원하지 않는 연산자 예외 처리 -> IllegalArgumentException
    - [x] 0으로 나눌 때 예외 처리 -> ArithmeticException


# 📌 Racing Car

## 기능 요구 사항
초간단 자동차 경주 게임을 구현한다.

- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 각 자동차에 이름을 부여할 수 있다. 자동차 이름은 5자를 초과할 수 없다.
- 자동차 이름은 쉼표(,)를 기준으로 구분한다.
- 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 사용자는 몇 대의 자동차로 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
- 자동차의 상태를 화면에 출력한다. 어느 시점에 출력할 것인지에 대한 제약은 없다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다. 

## 기능 구현 사항
- [x] 자동차 이름 입력받기(Input.getCarName)
  - [x] 참가 자동차는 2대 이상. (Validator.validatePossibleToStart)
  - [x] 문자열에 들어온 공백 제거. (Input.removeBlank)
  - [x] 자동차 이름은 `,`로 구분. (Input.splitNameByComma)
  - [x] 자동차 이름별로 객체 생성(이름) (RacingCar)
    - [x] 자동차의 이름 글자수 5자 이하인가. (Validator.validateNameLength)
    - [x] 자동차 한칸 전진.(RacingCar.forward)
    - [x] 전진 여부 (RacingCar.canForward)
- [x] 시도 횟수 입력(Input.getTrial)
  - [x] 숫자가 아닌 입력 예외처리. (Validator.isNumber)
- [x] 게임 진행(RacingGame.start)
- [x] 게임 View 출력.
  - [x] 게임 진행 현황 출력. (RacingGameView.printProgress)
    - [x] 자동차의 이름과 현재 위치 반환.(carResultView.drawCurrPosition)
  - [x] 우승자 출력. (RacingGameView.printWinners)
- [x] 우승자 판별(Judge.getWinners)