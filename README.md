# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## Step3
* Input
  * 유저는 countOfCar, countOfTry 를 입력한다.
  * countOfCar, countOfTr y를 반환
* CarList
  * Car 로 이루어진 일급 컬랙션
  * CarList 를 만들고 Car 에게 move 를 시키는 전략인자로 받아 Car 에게 넘겨준다.
* Car
  * position 을 인스턴스 변수로 가지고있다.
  * move 할 수 있는 로직을 담고있다.
* ConvertOutputView
  * car 의 정수형의 position 을 String 의 "-"로 매핑해준다
* MoveStrategy Interface
  * boolean 을 리턴하는 method 추상화
* RandomMoveStrategyImpl
  * MoveStrategy 구현체이며 10 사이의 random 한 값이 4보다 크면 true 를 return 한다
* OutPut
  * 바뀌는 자동차 상태를 출력
