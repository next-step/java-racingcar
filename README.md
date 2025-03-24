# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## Step 4 - 자동차 경주 (우승자)
### 요구 사항
각 자동차에 이름을 부여할 수 있다. 자동차 이름은 5자를 초과할 수 없다.
전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
자동차 이름은 쉼표(,)를 기준으로 구분한다.
자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한명 이상일 수 있다.
### 필수 기능 체크리스트
- [x] 객체 별 테스트 코드 작성 (Car, Cars, Name, TryCount, Winners)
- [x] 입/출력 View 생성
- [x] Car / Name (Validation 포함) / Position 객체 생성
- [x] NumberBasedCarMover 인터페이스 생성 (숫자에 따라 차를 움직일지 말지 결정하는 객체 생성을 위함)
  - [x] Test 를 위한 FixedNumberBasedCarMover 객체 생성
  - [x] 게임을 위한 RandomNumberBasedCarMover 객체 생성
- [x] Cars 객체 생성 (Car 들에 대한 단위 기능 수행)
- [x] Winners / TryCount / RacingCarGame 객체 생성 (자동차 경주 게임 진행)


## Step 3 - 자동차 경주
### 요구 사항
주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
사용자는 몇 대의 자동차로 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4이상일 경우이다.
자동차의 상태를 화면에 출력한다. 어느 시점에 출력할 것인지에 대한 제약은 없다.
### 필수 기능 체크리스트
- [x] 자동차 객체 및 이동 구현
- [x] 게임 시작 시 자동차 객체 초기 init 구현
- [x] UI 로직 구현 (InputView, OutputView)
- [x] 자동차 경주 게임 구현

