# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.


## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)


## 기능 요구 사항
* 주어진 횟수동안 n대의 자동차는 전진 또는 멈출수있다.
* 각 자동차에 이름을 부여할수 있다.전진하는 자동차를 출력할 때 자동차이름을 같이 출력한다.
* 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자이하만 가능하다.
* 사용자는 몇번의 이동을 할것인지를 입력할 수 있어야한다.
* 전진하는 조건은 0에서 9사이에서 random값을 구한 후 random값이 4이상 일경우 전진하고,
  3이하의값이면멈춘다.
* 자동차 경주게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한명 이상일 수 있다.


## 상수 값 정의
* CAR_NAME_LENGTH_LIMIT
  * 변수 타입 : Integer
  * 상수 값 : 5
  * 설명 : 자동차 생성 제한 길이
  
* CAR_NAME_SPLIT_DELIMITER
  * 변수 타입 : String
  * 상수 값 : ,
  * 설명 : 여러 대의 자동차의 이름의 구분자
  
* CAR_FORWARD_STOP_RANDOM_BOUNDS
  * 변수 타입 : Integer
  * 상수 값 : 9
  * 설명 : 자동차 전진 및 정지를 하기위해 램덤 값
  
* CAR_FORWARD_LIMIT
  * 변수 타입 : Integer
  * 상수 값 : 4
  * 설명 : 자동차 전진을 하기 위한 조건, CAR_FORWARD_STOP_RANDOM_BOUNDS가 4 이상이면 전진

* CAR_STOP_LIMIT
  * 변수 타입 : Integer
  * 상수 값 : 3
  * 설명 : 자동차 정지를 하기 위한 조건, CAR_FORWARD_STOP_RANDOM_BOUNDS가 3 이하면 정지