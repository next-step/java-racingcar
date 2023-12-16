# 🚀 3단계 - 자동차 경주
------------
## 기능 요구사항
* 사용자 입력 view
    * [x] 사용자에게 값을 입력받는다.
    * [x] 입력값이 없는 경우 에러를 던진다.

* 자동차의 상태 view
    * [x] 시도 횟수만큼 n대의 자동차 이동 현황을 보여준다. 

* 자동차의 이동
    * [x] 0에서 9사이의 random 값을 구한다.
    * [x] random 값이 4이상일 떄 전진한다.
    * [x] random 값이 3이하일 떄 정지한다.

## 프로그래밍 요구사항
* 모든 로직에 단위 테스트를 구현한다. 단, UI(System.out, System.in) 로직은 제외
  * 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 구분한다.
  * UI 로직을 InputView, ResultView와 같은 클래스를 추가해 분리한다.
* 자바 코드 컨벤션을 지키면서 프로그래밍한다.
  * 이 과정의 Code Style은 intellij idea Code Style. Java을 따른다.
  * intellij idea Code Style. Java을 따르려면 code formatting 단축키
  (Windows : Ctrl + Alt + L. Mac : ⌥ (Option) + ⌘ (Command) + L.)를 사용한다.
* else 예약어를 쓰지 않는다.
  * 힌트: if 조건절에서 값을 return하는 방식으로 구현하면 else를 사용하지 않아도 된다.
  * else를 쓰지 말라고 하니 switch/case로 구현하는 경우가 있는데 switch/case도 허용하지 않는다.

## 참고
