# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 요구 사항
* 사용자로부터 자동차 이름과 시도할 횟수를 입력으로 받는다.
* 전진하는 조건을 Random class를 이용해 구현한다. Random값이 4 이상일 경우 전진한다.
* 자동차의 상태를 횟수마다 화면에 출력한다.
* 각 자동차에 이름을 부여할 수 있다. 자동차 이름은 5자를 초과할 수 없다.
* 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
* 자동차 이름은 쉼표(,)를 기준으로 구분한다.
* 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한명 이상일 수 있다.

## 기능 목록
* InputView를 통해 사용자로부터 자동차의 이름과 시도할 횟수를 입력으로 받는다.
* 자동차 객체를 만드는 객체를 구현한다.
* 입력받은 자동차 이름을 분리하여 자동차 객체를 만든다.
* 난수를 발생시켜 자동차의 상태를 정한다.
* 시도한 횟수만큼 경주를 진행하는 객체를 구현한다.
* OutputView를 통해 자동차의 이름과 상태를 화면에 출력한다.
* 자동차 경주 게임을 완료한 후 우승자가 누구인지 확인한다.
* OutputView를 통해 우승자가 누구인지 화면에 출력한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)