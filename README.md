# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)


---
# Step3 - 자동차 경주 요구사항 분석

#### RaceManager (경주 관리자)

- 자동차(운전자) 대수, 시도할 라운드 수의 양수값을 입력 받고 DriverRecruiter, CarManager, RoundManager 에게 전달한다

#### DriverRecruiter (운전자 모집자)

- RaceManager로 부터 필요한 Driver 수를 입력받는다
- 자동차 경주에 필요한 Driver를 모집한다

#### CarManager (자동차 매니저)

- RaceManager에게 필요한 자동차 대수를 입력받는다
- 경주에 필요한 자동차를 준비한다
- 경주 시작전 모든 자동차는 시작점(0)에 위치하도록 한다

#### RoundManager (라운드 관리자)

- RaceManager에게 필요한 라운드 수를 입력받는다
- 시도할 라운드를 관리한다
- 각 라운드마다 Driver 에게 신호를 준다
- 자동차 경주 시작 전, 각 라운드가 끝나면 RaceRecorder 에게 알려준다

#### RaceRecorder (경주 기록자)

- 경주에 참여한 각 Car 를 주시한다 
- RoundManager 의 라운드 종료 신호에 따라 각 라운드를 누적해서 기록한다

#### Driver (운전자)

- RoundManager 의 신호에 따라 각 라운드마다 전진하거나 멈춘다
- 전진하는 조건은 0 ~ 9 사이의 랜덤 값이 4이상일 경우이다 [6(전진):4(멈춤)]

#### Car (자동차)

- **멈춤**, **전진**할 수 있다
- 각 자동차가 전진하면 RaceRecorder 는 이를 알아차릴 수 있다


