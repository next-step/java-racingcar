# 자동차 경주 게임
## 기능 요구사항
* 각 자동차에 이름을 부여할 수 있다. 자동차 이름은 5자를 초과할 수 없다.
* 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
* 자동차 이름은 쉼표(,)를 기준으로 구분한다.
* 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한명 이상일 수 있다.

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
 * Car : 자동차 경주에 따른 정보를 관리하는 객체
    * 메소드
        * getMovePower() - 자동차의 power
        * moveCarCheck() - 자동차의 power에 따른 이동
    * 주요 변수
        * String[] raceCarNames - 경주에 참여한 자동차 이름(배열)
        * HashMap<String, List<CarRaceMoveInfo>> carReacMoveInfoList - 자동차 이름에 따른 경주기록
        * int raceTryCount - 시도횟수
 * RunCarRace : 레이싱 시작 관리 클래스
    * run() - 레이싱 시작
    * inputValue() - 파라미터를 받는 메소드
    * repeatTryMoveCar() - 시동할 횟수를 반복
    * repeatCar - 자동차 갯수를 반복
 * ErrorMessage : 에러메세지 관리 클래스
 * InputCarData : 입력받은 값 체크 클래스
    * inputValue - 키보드로 입력받는 메소드
    * checkTryCount - 입력 받은 시도횟수 값 체크
    * checkName - 입력받은 자동차 이름 체크
 * RaceResultPrint :  자동차 진행결과 및 우승자 그리는 관리 클래스
    * runPrintRaceResult - 그리기 시작하는 메소드
 * RunCarRace : 자동차 경기 관리 클래스
    * start : 경기 시작
    * runRace : 레이스 시작
 * ExtractWinner : 우승자 관리 클래스
    * ExtractRun : 결과에서 우승자 뽑기

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)
