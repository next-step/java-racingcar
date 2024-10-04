# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## 기능 요구사항
- InputView
  - 각 자동차에 이름을 부여할 수 있음 (자동차 이름은 5자를 초과할 수 없음)
  - 자동차 이름은 쉼표(,)를 기준으로 구분
- RacingGame
  - 사용자가 입력한 이름의 숫자 만큼 자동차 대수를 생성 
  - 자동차 이름과 위치 정보를 가지는 Car 객체를 추가해 구현
- ResultView
  - 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력
  - 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려줌 (우승자는 한명 이상일 수 있음)
- Movement
  - 자동차 움직이는지 여부 판단
- Car
  - 자동차 이름과 위치 정보를 가지고 있음
  - 자동차는 전진 또는 멈출 수 있음 (Movement에 따라 결정)
- Winner
  - 우승자를 판단 (가장 멀리 간 자동차가 우승자)
