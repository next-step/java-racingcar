# 3단계 - 자동차 경주

---
## 기능 요구사항
* 초간단 자동차 경주 게임을 구현한다.
* 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
* 사용자는 몇 대의 자동차로 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
* 전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4이상일 경우이다.
* 자동차의 상태를 화면에 출력한다. 어느 시점에 출력할 것인지에 대한 제약은 없다.

---
## 프로그래 요구사항
* 모든 로직에 단위 테스트를 구현한다. 단, UI(System.out, System.in) 로직은 제외
    * 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 구분한다.
    * UI 로직을 InputView, ResultView와 같은 클래스를 추가해 분리한다.
* 자바 코드 컨벤션을 지키면서 프로그래밍한다.
    * 참고문서: https://google.github.io/styleguide/javaguide.html 또는 https://myeonguni.tistory.com/1596
* else 예약어를 쓰지 않는다.
    * 힌트: if 조건절에서 값을 return하는 방식으로 구현하면 else를 사용하지 않아도 된다.
    * else를 쓰지 말라고 하니 switch/case로 구현하는 경우가 있는데 switch/case도 허용하지 않는다.
    
---
## 기능 목록 및 commit 로그 요구사항
* 기능을 구현하기 전에 README.md 파일에 구현할 기능 목록을 정리해 추가한다.
* git의 commit 단위는 앞 단계에서 README.md 파일에 정리한 기능 목록 단위로 추가한다.
    * 참고문서: AngularJS Commit Message Conventions
    
---
## Feature List
1. README.md 작성
2. CarRacing 메인 클래스
3. 입력값을 받는 UI 클래스
4. 입력값을 전달하는 데이터 클래스
5. Car 클래스
6. 입력 값을 토대로 Car들을 저장하고 경주를 시도 하는 클래스
7. Car 클래스의 go 결과를 반환 할 클래스
8. 1회 경주 시도 결과를 전달하는 클래스
9. 입력 값을 토대로 경주를 컨트롤 하는 클래스
10. 경주 결과를 전달하는 데이터 클래스
11. 경주 결과를 출력해주는 UI 클래스

---
## Refactoring List Follow Code Review 
1. Reception, Announcer 클래스에 private 생성자 추가 및 Reception 클래스의 takeParticipationForm 중복 제거
2. UI 패키지 추가, MessageConstant 클래스 추가, RaceCondition->RacePlayers 명칭 변경 및 내부 private 메소드 정의
3. collections 패키지 분리, 테스트 코드만을 위한 size 메소드 제거 후 eqaulsAndHashcode 재정의로 테스트코드에서는 동등성 비교
4. ControlTower에 멤버 변수로 RacePlayers 갖게 변경, ControllTowerTest 클래스의 테스트 검증에 객체 동등성 비교 사용, Car 클래스의 불필요한 메서드 제거
5. MoveStrategy 인터페이스 추가 및 구현체로 Dice 추가 (Car에서 랜덤 요소 분리)가, Car 클래스 리팩토링, Dice 테스트 추가, Car 테스트 수정, constants 패키지 추가

---
## Refactoring List Follow 2nd Code Review
1. refactor - step2 코드리뷰 반영
    1. ExpressionSeparator 생성자에서만 쓰이는 배열 멤버변수에서 제거
    2. 불필요한 Wrapper class -> primitive type으로 변경
    3. ExpressionSeparator 내부의 InputNumbers, InputOperators 생성 메소드 로직은 각 클래스 생성자로 이동
2. refactor - step3 2차 코드리뷰 반영
    1. equlasAndHashCode 클래스 맨 아래로 이동
    2. 불필요한 Wrapper class -> primitive type으로 변경
    3. AttemptResult.getFirstCarNumber 오타 수정
    4. RacePlayers -> RacingCars 이름 변경
    5. MoveStrategy 제네릭 제거, Random의 범위를 제한하는 Wrapper Class 인 BoundedDice 클래스 작성
    6. Announcer 클래스 내부 메소드 좀더 쪼개기
3. refactor - step2 2차 코드리뷰 누락 분 반영(불필요한 Wrapper class -> primitive type)