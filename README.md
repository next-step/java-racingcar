# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## 기능 요구사항
* 각 자동차에 이름을 부여할 수 있다. 자동차 이름은 5자를 초과할 수 없다.
* 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
* 자동차 이름은 쉼표(,)를 기준으로 구분한다.
* 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한명 이상일 수 있다.
## 기능목록

### RacingCarApplication
* RacingCarGame 을 시작한다.

### RacingCarGame
* 전체적인 로직을 담당한다.
* 게임을 시작한다.
* 차량들의 이름을 입력받는다.
* 시도 회수를 입력받는다.
* 시도 회수만큼 각각 차를 이동시킨다.
* 가장 긴 이동거리를 구한다.
* 우승자를 가린다.

### InputView
* 차량 이름 입력 메세지를 출력한다.
* 시도 회수 입력 메세지를 출력한다.

### ResultView
* 실행 결과 메세지를 출력한다.
* 실행 결과를 출력한다.
* 우승자를 출력한다.

### Car
* 차는 움직인다.
* 이름이 5자를 초과하면 예외를 발생시킨다.

### CarFactory
* Car 를 생성한다.