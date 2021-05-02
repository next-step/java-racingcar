# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)



## 구현기능 
* 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다. 
* 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다. 
* 자동차 이름은 쉼표, 기준으로 구분하며 이름은 5자 이하만 가능하다. 
* 사용자는 몇 번의 이등을 할 것인지를 입력할 수 있어야 한다. 
* 전진하는 조건은 0, 9 사이에서 random 값을 구한 후 random 값이 4일 경우 전진하고, 3이하이면 멈춘다. 
* 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수있다..


## 생각할 문제
* 이동 메서드를 어느 클래스에서 구현할 것인가?
  * 이동을 하는 주체는 racingcar 
  * 이동 거리를 나타내는 MovingDistance 클래스

## TODO LIST
* RacingCar 객체 생성 
* 이름, 이동거리 속성 생성  
  * 이름은 5자를 넘지 않는다.
  * 이동거리는 0, 9까지의 수를 갖는다. 
* 이동 메서드를 생성 
  * 4 이상의 경우만 전진, 3 이하면 멈춘다.
* 원시값 문자열 포장
  

    
  