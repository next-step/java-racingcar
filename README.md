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
* UI 로직 기능1 : 리턴형 void 이고 매개변수로 move 매소드 호출 결과인 int 형 배열을 받아 
  콘솔에 1회 경주당 자동차들의 전진을 출력하는 printMoveRacingCar 매소드이다.
  매개변수로 받는 int 형 배열의 요소갯수 만큼 해당 value 를 매개변수로 printRunCar 메소드를 호출한다.
* UI 로직 기능2 : 자동자들의 run count 정보를 담고있는 int형 배열인 carPositions 요소의 value 값 만큼 
  '-'을 출력해서 콘솔에 보여주는 리턴형 void 이고 자동차 전진횟수를 의미하는 int 형 매개변수가 있는 printRunCar 매소드이다.
* UI 로직 기능3 : 핵심 로직 클래스인 RacingCarGameEngine 인스턴스를 매개변수로 하고 RacingCarGameEngine 의 인스턴스 변수중
  int 형인 numbersOfRacing 값만큼 move 와 printRacingCars 를 호출하는 void 리턴형인 goRacingGame 매소드이다. 
* UI 로직 기능4 : 사용자 입력값이 유효한 값이 올때까지 입력을 받도록 유도하는 void 리턴형 startGame 매서드이다.
  getRacingCarGameEngine 의 호출결과 유효하지 않은 값이 입력되면 발생하는 IllegalArgumentException 을 catch 하여 
  사용자 입력받는 부분을 다시 호출하도록 한다. 유효한 값이 입력되면 getRacingCarGameEngine 호출 결과 리턴받는 
  RacingCarEngine 인스턴스를 매개변수로 goRacingGame 를 호출한다.
* UI 로직 기능5 : 사용자에게 유효한 정보를 입력받아 RacingCarEngine 인스턴스를 생성하여 리턴하는 getRacingCarGameEngine 매소드이다.
  입력받은 값이 유효한지 검사하는 validateUserInputValues 를 호출하여 유효하지 않으면 IllegalArgumentException 를 발생시킨다.
  
##자동차 경주 게임 step3 기능 목록(기능 목록 단위로 commit)
어떤 기능이 동작하여야 하고(경계값 및 조건 등), 
어떤 부분에 대한 유효성을 검증할 것인지를 중심 
* 자동차 이름과 위치정보를 가지는 Car 클래스 생성
* 입력받는 String의 최소길이는 2 (쉼표 포함한 한글자)
* 입력받는 String 을 쉼표(,) 로 자르는 기능 ::: String 클래스의 split(",") 메소드를 활용
* 쉼표(,)로 자른 문자열 배열의 길이가 0 인지 유효성 검사
* 쉼표로 잘린 문자열이 빈 문자열이 인지 유효성 검사
* int 형 배열이였던 carPositions 를 List 로 변경한다.

* 문자열 배열의 길이 크기로 carPositions 배열 생성

* 사용자가 입력한 이름과 이름의 위치로 Car 객체를 생성한다.
* 자동차의 이름 출력과 해당 자동차의 전진 출력을 한 줄로 조합하여 출력하는 기능
* 우승자는 가장 높은 전진횟수를 가진 요소의 값이 동일하게 복수개일때 모든 우승자들의 정보를 리턴한다.
* 우승자이름 문자열과 "가 최종 우승했습니다." 문자열을 한 줄로 조합하여 출력하는 기능
  ex) 우승자1,우승자3가 최총 우승했습니다



기능 요구사항
전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한명 이상일 수 있다.


힌트
규칙 1: 한 메서드에 오직 한 단계의 들여쓰기(indent)만 한다.
indent가 2이상인 메소드의 경우 메소드를 분리하면 indent를 줄일 수 있다.
else를 사용하지 않아 indent를 줄일 수 있다.


실행 결과
위 요구사항에 따라 3대의 자동차가 5번 움직였을 경우 프로그램을 실행한 결과는 다음과 같다.

경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).
pobi,crong,honux
시도할 회수는 몇회인가요?
5

실행 결과
pobi : -
crong : -
honux : -

pobi : --
crong : -
honux : --

pobi : ---
crong : --
honux : ---

pobi : ----
crong : ---
honux : ----

pobi : -----
crong : ----
honux : -----

pobi : -----
crong : ----
honux : -----

pobi, honux가 최종 우승했습니다.




