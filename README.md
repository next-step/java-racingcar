# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## 요구사항
- 초간단 자동차 경주 게임을 구현한다.
- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 사용자는 몇 대의 자동차로 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다. 
- 차량이 전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4이상일 경우이다.
- 자동차의 상태를 화면에 출력한다. 어느 시점에 출력할 것인지에 대한 제약은 없다.
- 각 자동차에 이름을 부여할 수 있다. 자동차 이름은 5자를 초과할 수 없다.
- 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분한다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한명 이상일 수 있다.

## 기능 구현 사항
- [V] 게임을 시작하면 몇 가지 세팅을 입력받고 자동차 경주가 시작된다.
- [V] 차량 대수를 입력받고 그 차량 수만큼 자동차 경주를 한다.
- [V] 자동차 이름을 원하는 만큼 부여받고 쉼표로 구분한다. (자동차 이름은 5자를 초과할 수 없다)
- [V] 경주 진행 횟수를 입력받고 그 진행 수만큼 자동차 경주를 진행한다.
- [V] 매 진행마다 차량들은 이동할 기회를 얻는다.
- [V] 매 진행이 끝날때마다 자동차 경주 상황을 전달해야 한다.
- [V] 자동차 경주 상황을 전달받을 때마다 인식 가능하게 출력하여야 한다.
- [V] 자동차 경주 상황 출력시 이름도 같이 출력해야 한다.
- [V] 자동차 경주 게임을 완료한 후 누가 우승했는지 알려줘야 한다. 우승자는 한명 이상일 수 있다.
- [V] 자동차는 이동 가능하여야 한다.
- [V] 차량 이동시 이동조건, 이동기회값을 받아서 이동기회값이 이동조건을 만족하면 이동해야 한다.
- [V] 자동차의 이동조건은 랜덤한 값(0~9)을 받고 랜덤 값이 4이상일때 이동이 가능해야 한다.