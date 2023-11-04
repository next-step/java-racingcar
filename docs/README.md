# 기능 요구사항

-[x] 사용할 자동의 수를 입력 받는다.
  -[x] 입력 받는 수는 정수만 가능하다.
-[x] 몇번의 이동이 가능 할 것인지 입력 받는다.
  -[x] 입력 받는 수는 정수만 가능하다.
-[x] 입력한 수 만큼 자동차가 생성되어야 한다.
-[ ] 자동차는 전진 또는 멈출 수 있다.
  -[ ] 자동차가 전진하려면 0~9 사이의 랜덤 값을 구한 후 4 이상인 경우다.
  -[ ] 랜덤값이 3이하인 경우는 자동차는 움직이지 않는다. 
-[ ] 자동차의 상태를 화면에 출력한다.

# 프로그래밍 요구사항
- 모든 로직에 단위 테스트를 구현한다. 단, UI(System.out, System.in) 로직은 제외
- 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 구분한다.
- UI 로직을 InputView, ResultView와 같은 클래스를 추가해 분리한다.
- 자바 코드 컨벤션을 지키면서 프로그래밍한다.
- 이 과정의 Code Style은 intellij idea Code Style. Java을 따른다.
- intellij idea Code Style. Java을 따르려면 code formatting 단축키(Windows : Ctrl + Alt + L. Mac : ⌥ (Option) + ⌘ (Command) + L.)를 사용한다.
- else 예약어를 쓰지 않는다.
  - 힌트: if 조건절에서 값을 return하는 방식으로 구현하면 else를 사용하지 않아도 된다.
  - else를 쓰지 말라고 하니 switch/case로 구현하는 경우가 있는데 switch/case도 허용하지 않는다.