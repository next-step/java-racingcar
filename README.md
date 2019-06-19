# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

##자동차 경주 게임 step2 기능 목록(기능 목록 단위로 commit)
* 클래스 생성 : 핵심 로직 클래스인 RacingCarGameEngine, 핵심 로직을 테스트 하는 RacingCarGameEngine, 
  UI 로직 클래스인 RacingCarGameFront 만든다.
* 초기화 : 사용자 입력을 받은 몇 대의 자동차 정보는 RacingCarGameEngine 클래스의 인스턴스 변수인 
  int형 배열인 carPositions 을 입력받은 수의 크기로 배열을 생성한다. 배열의 value 는 자동차가 전진한 횟수에 해당한다.
  사용자 입력을 받은 경주 할 회수 정보는 RacingCarGameEngine 클래스의 
  int형 인스턴스 변수 numbersOfRacing 의 값으로 셋팅한다.
* 입력값 validate : 사용자 입력으로 받는 숫자는 1이상의 숫자여야 한다.
  1보다 작은 값이 사용자 입력으로 들어올 경우 IllegalArgumentException 을 발생시키는 validateUserInputValue 매소드이다.
* 핵심 로직 기능1 : 자동차가 run 할 수 있는 조건을 체크하는 리턴형이 boolean 이고 매개변수로 int 형을 인자 하나를 가지는 
  checkRunCondition 메소드를 생성한다. 해당 매소드가 true 를 return 하는 조건은 매개변수로 인자가 4 이상일 경우이며
  0,1,2,3 과 같은 수가 매개변수로 올 경우엔 false를 return 한다.
* 핵심 로직 기능2 : 자동차가 전진한 회수를 리턴하는 리턴형이 int 형이고 매개변수로 boolean 형인 전진여부를 담는 매개변수와 
  int 형인 기존의 전진한 회수를 받는 getRunCount 매소드를 생성한다. 
  boolean 형 매개변수가 true 이면 int 형 매개변수에 ++1 한 값을 리턴해주고, false 이면 int 형 매개변수 그대로 리턴한다.
* 핵심 로직 기능3 : 경주에 참여하는 자동차들이 1회씩 경주한 결과를 리턴하는 리턴형 int[] 인 move 매소드이다.
  경주에 참여하는 자동차 수 만큼 Random(10) 호출 결과를 checkRunCondition 매소드의 매개변수에 넣어주고,
  checkRunCondition 의 리턴값은 getRunCount 매소드의 boolean 형 매개변수에 담고 int 형 매개변수에는
  해당 자동차 포지션에 해당하는 carPositions 의 value 를 담는다. move 매소드의 리턴값은 1회 경주한 후 경주한 자동차들의
  전진한 횟수를 담는 int 형 배열이다.
* UI 로직 기능1 : move 매소드 호출 후 리턴형 int[] 의 각각의 요소의 value 값 만큼 '-'을 출력해서 콘솔에 보여주는
  리턴형 void 이고 매개변수가 없는 printRacingCar 매소드이다.
* UI 로직 기능2 : 사용자 입력으로 받은 경수 횟수 만큼 printMoveRacingCar 를 호출하는 void 리턴형이고 매개변수가 없는 
  goRacingGame 매소드이다. 
* UI 로직 기능3 : 사용자 입력값이 유효한 값이 올때까지 입력을 받도록 유도하는 void 리턴형 tryValidUserInputValue 매서드이다.
  valicateUserInputValue 의 호출결과 exception 을 catch 하여 사용자 입력받는 부분을 다시 호출하도록 한다.
* UI 로직 기능4 : 사용자가 원하는 정보를 입력하도록 유도하는 void 리턴형 doUserInputValue 매서드이다.




