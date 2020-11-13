# 자동차 경주 게임
## 기능 요구사항
* 핵심 비지니스 로직을 가지는 객체를 domain 패키지, UI 관련한 객체를 view 패키지에 구현한다.
* MVC 패턴 기반으로 리팩토링해 view 패키지의 객체가 domain 패키지 객체에 의존할 수 있지만, domain 패키지의 객체는 view 패키지 객체에 의존하지 않도록 구현한다.

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

 ## 기능목록
 * CarRacingGame : 자동차 경주에 따른 정보를 관리하는 객체
    * 메소드
        * playRacingGame() - 게임 시작 메소드
        * drawRasingWinner() - 자동차 경주 우승자 그려주는 메소드
        * drawRasingGame() - 자동자 경주 기록 그려주는 메소드
    * 주요 변수
        * String[] raceCarNames - 경주에 참여한 자동차 이름(배열)
        * HashMap<String, List<CarRaceMoveInfo>> carReacMoveInfoList - 자동차 이름에 따른 경주기록
        * int raceTryCount - 시도횟수
* Car : 자동차 정보를 관리하는 객체
    * 메소드
        * moveCar() - 외부의 값을 받아서 자동차 이동
    * 주요 변수
        * carName - 자동차 이름
        * moveDistance - 이동 거리
* CarDataCheck : 입력된값 체크
    * 메소드
        * checkTryCount - 시도횟수값 체크
        * checkName - 이름을 올바르게 입력했는지 체크
* CarRasingDraw : 자동차를 그려줄때 도움주는 클래스
    * 메소드
        * changeNumberToChar - 이동거리만큼 '-' 반환
* CarDataCheckTest : 입력값 테스트
* CarTest : car객체 테스트

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)
