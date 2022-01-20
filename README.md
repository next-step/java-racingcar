## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

# 문자열 계산기 🧮
## 기능 구현 목록
- [x] 계산기 - Calculator
  - [x] 사용자입력 - Calculator#getUserInput
  - [x] 예외 처리 : 다시 입력하라는 안내 문구 출력 
    - [x] 정규표현식으로 잡을 것들 - Validator#checkValidate
      - [x] 입력값이 null이거나 빈 공백 문자일 경우
      - [x] 사칙연산 기호가 아닌 것이 들어가 있을 경우 (문자, %, ...)
      - [x] 숫자 다음 사칙연산 기호가 아닌 다른 숫자가 오는 경우 (e.g. 33 * 1 23)
      - [x] 사칙연산 기호 다음 기호가 또 나오는 경우 (e.g. 33 + + 1)
      - [x] 사칙연산 기호가 제일 앞이나 제일 뒤에 올 경우
  - [x] 입력값을 숫자와 연산기호로 나누어 관리한다. - Expression
    - [x] 문자열 내에 있는 공백을 모두 지운다. 
    - [x] 숫자와 문자로 나누어 List로 관리한다.
    - [x] 연산 중 0으로 나누는 경우에 대한 예외처리 - Calculator#checkDivideZero
    - [x] 계산결과 출력 - Expression#printResult
- [x] 사칙연산 - Operation
    - [x] 덧셈 - Operation#addition
    - [x] 뺄셈 - Operation#subtraction
    - [x] 곱셈 - Operation#multiplication
    - [x] 나눗셈 - Operation#division


# 자동차 경주 게임
## 기능 구현 목록 
- [X] 게임 진행    RacingGame
  - [X] 사용자의 입력을 받으면서 게임을 진행하는 로직   #startGame()
  - [X] 입력 다 마치고 자동차 경기 시작   #startRacing()
    - [X] 각 자동차들을 움직임   #driveCars()
    - [X] 자동차 위치의 최대값을 갱신   #setMaxPosition()
  - [X] 경주가 끝나고 우승자 출력    #showGameResult()

- [X] 사용자 입력   UserInput
  - [X] 각 자동차에 이름을 부여하기 위한 사용자 입력   #getCarNames()
    - [X] 각 자동차의 이름은 쉼표를 기준으로 구분 (문자와 쉼표 사이의 공백 있어도 상관X)   #splitStringByComma()
    - [X] 각 자동차 이름의 길이는 1 ~ 5자 까지 가능   #checkNameLength()
    - [X] 자동차는 최소 1대, 최대 n대 까지 입력 가능   #checkCarCount()
    - 잘못 입력한 경우에는 [ERROR] 메세지와 함께 다시 입력 받음
  - [X] 시도 횟수를 정하기 위한 사용자 입력   #getTryNumber()
    - [X] 1 이상의 정수만 입력 가능   #isNumber(), #isTryNumberValidLength()
    - 잘못 입력한 경우에는 [ERROR] 메세지와 함께 다시 입력받음

- [X] 각 자동차의 상태를 관리   Car
  - [X] 자동차의 이름, 전진 상태 
  - [X] 자동차를 전진할지 정지할지 결정   #drive()
    - [X] 자동차를 전진/정지 상태 업데이트
    - [X] 자동차의 전진조건 확인   #isMove()
      - 생성한 랜덤 정수가 4 이상인 경우 true 를 반환
    - [X] 랜덤한 정수 생성   #generateRandomNumber()
      - 0 ~ 9 의 랜덤한 정수를 반환
    - [X] 자동차의 상태 출력   #printStatus()