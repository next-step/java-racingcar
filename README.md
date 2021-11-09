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
  * 유저는 countOfCar, countOfTry를 입력한다.
  * countOfCar, countOfTry를 List에 담아서 반환
* MoveOrStop
  * inputCarList와 countOfTry를 입력 받는다   
  * inputCarList의 Car들이 moveOrStop한다.
    * randomList의 원소가 4보다 크면 해당 인덱스의 carList 원소 값이 move
      * 원소에 "-"를 더해준다
    * 아니라면 stop한다
      * 그대로 반환한다
* MakeRandomList
  * countOfCar를 입력으로 받는다. 
  * countOfCar만큼 randomNum이 들어간 randomList를 만든다.
* CarList
  * countofCar를 입력으로 받는다. 
  * countOfCar만큼의 size의 "-"를 원소로 가지는 List 생성. 
* OutPut
  * Input, MoveOrStop, MakeRandomList, CarList를 통해서 바뀌는 자동차 상태를 출력
