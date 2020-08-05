# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)


## 3단계 - 구현할 기능 목록
#### 입력
- UI를 담당하는 객체(InputView) 생성
- 자동차 대수 입력 받기
- 경기 횟수 입력 받기

#### 처리
- 레이싱 자동차 객체(RacingCar) 생성 및 기능 구현
- 레이싱 라운드 객체(RacingRound) 생성 및 기능 구현
- 레이싱 녹화 객체(RacingRecord) 생성 및 기능 구현
- 레이싱 규칙 객체(RacingRule) 생성 및 기능 구현
- 레이싱 경기 객체(RacingGame) 생성 및 기능 구현

#### 출력
- 레이싱 결과를 출력하는 객체(ResultView) 생성

#### TEST
- 테스트 코드 작성


## 4단계 - 구현할 기능 목록
#### 입력
- 자동차 이름을 입력 받음
- 자동차 이름은 5자를 초과할 수 없음 
- 자동차 이름은 쉼표(,)를 기준으로 구분하고 자동차 대수를 의미함

#### 처리
- 레이싱 자동차 객체(RacingCar) 이름을 저장하는 필드 생성

#### 출력
- 자동차 주행시 이름을 출력
- 자동차 경주 완료 후 우승자를 출력함 (우승자는 한명 이상일 수 있음)

#### TEST
- 테스트 코드 작성
