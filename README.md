# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## 기능 요구사항
* 초간단 자동차 경주 게임을 구현한다.
* 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
* 사용자는 몇 대의 자동차로 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
* 전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4이상일 경우이다.
* 자동차의 상태를 화면에 출력한다. 어느 시점에 출력할 것인지에 대한 제약은 없다.

### InputView
* cars : 자동차 대 리턴
* rounds : 시도 횟수 리턴
* inputCarsValidator : 입력된 문자 ','로 split
* inputRoundValidator : 숫자 입력 확인
* isGreaterThan0 : 0보다 큰 수인지 확인

### ResultView
* printResult : 매 라운드별 이름과 위치 프린트
* printPosition : 포지션만큼 위치 프린트
* printWinner : 우승자 이름 프린트

### Car
* Car : 자동차 객체 생성
* moveCar : 위치 이동

### RacingGame
* RacingGame : 자동차 댓수와 시도 횟수 세팅
* racing : 자동차 이동
* moveNowCar : 현재 해당 자동차 이동 여부 확인 후 이동
* getRandomNum : 이동여부 확인을 위한 랜덤 값 생성
* moveOrNot : 이동여부 return
* findWinners : 우승자 찾기

### Winner
* Winner : 우승자 객체 생성
* findWinnerNames : 최대 position과 동일한 Car의 name 구하기
* maxPosition : 최대 position값 구하기