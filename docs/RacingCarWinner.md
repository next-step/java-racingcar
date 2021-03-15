# 🚀 4단계 - 자동차 경주(우승자)
## 기능 요구사항
1. 각 자동차에 이름을 부여할 수 있다. 자동차 이름은 5자를 초과할 수 없다.   
2. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.   
3. 자동차 이름은 쉼표(,)를 기준으로 구분한다.   
4. 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한명 이상일 수 있다.   
   
## 실행 결과   
위 요구사항에 따라 3대의 자동차가 5번 움직였을 경우 프로그램을 실행한 결과는 다음과 같다.
```
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
```
## 힌트
* 규칙 1: 한 메서드에 오직 한 단계의 들여쓰기(indent)만 한다.
  * indent가 2이상인 메소드의 경우 메소드를 분리하면 indent를 줄일 수 있다.
  * else를 사용하지 않아 indent를 줄일 수 있다.
* 자동차 이름을 쉼표(,)를 기준으로 분리하려면 String 클래스의 split(",") 메소드를 활용한다.
```java
String[] names = inputName.split(",");
```
* 사용자가 입력한 이름의 숫자 만큼 자동차 대수를 생성한다.
* 자동차는 자동차 이름과 위치 정보를 가지는 Car 객체를 추가해 구현한다.

## 프로그래밍 요구사항
* indent(인덴트, 들여쓰기) depth를 2를 넘지 않도록 구현한다. 1까지만 허용한다.
  * 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
  * 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메소드)를 분리하면 된다.
* 함수(또는 메소드)의 길이가 15라인을 넘어가지 않도록 구현한다.
  * 함수(또는 메소드)가 한 가지 일만 잘 하도록 구현한다.
* 모든 로직에 단위 테스트를 구현한다. 단, UI(System.out, System.in) 로직은 제외
  * 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 구분한다.
  * UI 로직을 InputView, ResultView와 같은 클래스를 추가해 분리한다.
* 자바 코드 컨벤션을 지키면서 프로그래밍한다.
  * 참고문서: https://google.github.io/styleguide/javaguide.html 또는 https://myeonguni.tistory.com/1596
* else 예약어를 쓰지 않는다.
  * 힌트: if 조건절에서 값을 return하는 방식으로 구현하면 else를 사용하지 않아도 된다.
  * else를 쓰지 말라고 하니 switch/case로 구현하는 경우가 있는데 switch/case도 허용하지 않는다.
* 기능 목록 및 commit 로그 요구사항
  * 기능을 구현하기 전에 README.md 파일에 구현할 기능 목록을 정리해 추가한다.
  * git의 commit 단위는 앞 단계에서 README.md 파일에 정리한 기능 목록 단위로 추가한다.
  
# 구현 목록(클래스 역할/책임)       
* Car :  
    * 자동차      
    * 지나온 길의 상태를 가지고 있다.    
    * 특정 조건에 대해서 움직일 수 있는지, 없는지를 판별한다.(활성 함수와 비슷)
* Name :   
    * 자동차 주인의 이름을 가지고 있다.     
    * 5글자 이상의 값을 가질 수 없다. -> 가진다면 에러 발생    
    * NameValidation 전략패턴을 이용하면 좋을 것 같다. 그런데 주입은 Car 에서 넣어줘야하나?    
    * Dirver에 소속되며 ResultView에서 Car를 통해 호출되어 사용되도록 한다.      
* Racing Round :  
    * 레이싱 라운드를 가지고 있는 클래스  
    * hasNext()로 다음 라운드가 존재하는지 확인한다.    
    * nextRound()를 통해 다음 라운드로 이동한다.      
    * 이전 미션과 동일한 방식으로 구성하면 될 것 같다.   
* StringUtils :
    * StringUtils에 쉼표를 String[]으로 분리시켜주는 static method를 정의한다.
* RacingCarRequestDto : 
    * Names 라는 클래스를 가진다.-> 분리한 String[]을 가진 일급 컬렉션이다.  
    * RacingRound를 가진다.
* GameStarter :
    * RacingController 를 실행하는 Main 클래스
* RacingGameController :
    * InputView/ResultView/RacingCarGame 을 조율하면서 실행
    * InputView 을 실행해서 Request 를 받는다.
    * 받아온 Request 를 통해 RacingCarGame 실행
    * RacingCarGame 에서 넘어온 Response 를 ResultView 으로 전달
* InputView :
    * 사용자에게서 `자동차 이름들`, `라운드`를 입력 받는다.
    * 받은 데이터를 `RequestDto`로 묶어서 한 번에 요청을 보낸다
        * RequestDto 생성
* RacingCarGame :
    * 레이싱을 진행
    * RacingCars, RacingRound 를 가지고 있다.
    * 얻어진 결과 값을 `ResponseDto`로 묶어서 ResultView 로 반환한다.
        * ResponseDto 생성
* ResultView :
    * `RacingCarGame` 에서 얻어온 ResponseDto 를 출력한다.
* RacingCars : 
    * RacingRequestDto로부터 Names를 넘겨받으면서 map을 통해서 Car를 만드는 로직을 넣도록 구성한다.
    * Controller에서 부터 넘겨받은 전략패턴(이동 가능한지에 대한 비교)을 받아서 Car를 생성한다.     
* Driver :
  * Car 객체와 Name 객체를 의존하고 있는 객체이다.
  * toString()을 정의해서 Car와 Name을 같이 출력을 하도록 한다.