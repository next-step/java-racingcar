# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)


기능 요구사항
- [ ] 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- [ ] 사용자는 몇 대의 자동차로 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- [ ] 전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4이상일 경우이다.
- [ ] 자동차의 상태를 화면에 출력한다. 어느 시점에 출력할 것인지에 대한 제약은 없다.

# 🚗 자동차 경주 게임 - TODO 리스트 (TDD)

## ✅ 자동차 (Car) 관련
- [x] 자동차의 현재 위치를 반환할 수 있다.
- [x] 자동차는 전진할 수 있다.

## 🎲 전진 조건 관련
- [ ] 0~9 사이의 랜덤 숫자를 생성할 수 있다.
- [x] 제공된 숫자가 4 이상이면 자동차가 전진한다.
- [x] 제공된 숫자가 3 이하이면 자동차는 멈춘다.
- [x] 움직일 수 있는 숫자를 판단하는 임계값은 생성자로 조절할 수 있다.
- [x] 제공된 숫자가 0이상 9이하 이외의 수는 예외를 발생한다.
- [x] 임계값으로 제공된 숫자 또한 0이상 9이하 이외의 수는 예외를 발생한다.



## 🏁 경주 관리 (Race) 관련
- [x] n대의 자동차를 생성할 수 있다.
- [ ] 지정된 횟수만큼 자동차 경주를 진행할 수 있다.
- [ ] 매 턴마다 모든 자동차의 상태를 갱신할 수 있다.
- [ ] 경주가 끝나면 최종 결과를 반환할 수 있다.  


## 👨‍💻프로그래밍 요구사항
### 모든 로직에 단위 테스트를 구현한다. 단, UI(System.out, System.in) 로직은 제외
  - 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 구분한다.
  - UI 로직을 InputView, ResultView와 같은 클래스를 추가해 분리한다.
### 자바 코드 컨벤션을 지키면서 프로그래밍한다.
- 이 과정의 Code Style은 [intellij idea Code Style. Java](https://www.jetbrains.com/help/idea/code-style-java.html)을 따른다.
- [intellij idea Code Style. Java](https://www.jetbrains.com/help/idea/code-style-java.html)을 따르려면 code formatting 단축키(Windows : Ctrl + Alt + L. Mac : ⌥ (Option) + ⌘ (Command) + L.)를 사용한다.
### else 예약어를 쓰지 않는다.
- if 조건절에서 값을 return하는 방식으로 구현하면 else를 사용하지 않아도 된다.
- else를 쓰지 말라고 하니 switch/case로 구현하는 경우가 있는데 switch/case도 허용하지 않는다.
