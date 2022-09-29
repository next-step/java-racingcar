# 자동차 경주 게임



## 패키지 구성



App : 프로그램의 전체 흐름을 관리하며 InputView로 부터 받은 데이터를 게임 시작을 위해 가공하는 책임을 지닌 객체



### game

Car :  레이스에 참가하는 자동차 객체로 랜덤 숫자 생성기를 돌려 일정 숫자 이상이 나왔을 때 앞으로 간다.

RacingGame : 게임을 진행하고 결과값을 반환하는 책임을 지닌 객체

- #### random

  - PositiveRandomNumber : 0이상의 수만 생성하는 랜덤 숫자 생성기
  - RandomNumber : 랜덤 숫자 생성기 인터페이스

- #### result

  - RacingResult : 레이스 라운드 결과들을 관리하고 게임 우승자를 파악하는 책임을 지닌 객체
  - RoundResult : 라운드 결과들을 관리하는 책임을 지닌 객체



### view

- InputView : 사용자 입력값을 검증하고 이를 App 객체에 전달하는 책임을 지닌 객체
- ResultView : 결과값으로 받은 데이터를 사용자에게 보여주는 책임을 지닌 객체

- #### valid

  - StringLengthValidator : 문자열 길이를 입력받은 길이와 비교해 검증하는 객체

