# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

---
# Step3
## ToDo

### 기능요구사항
1. 초간단 자동차 경주 게임을 구현한다.
2. 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
3. 사용자는 몇 대의 자동차로 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
4. 전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4이상일 경우이다.
5. 자동차의 상태를 화면에 출력한다. 어느 시점에 출력할 것인지에 대한 제약은 없다.

### 프로그래밍 요구사항
1. 모든 로직에 단위 테스트를 구현한다. 단, UI(System.out, System.in) 로직은 제외 
   1. 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 구분한다. 
   2. UI 로직을 InputView, ResultView와 같은 클래스를 추가해 분리한다.
2. 자바 코드 컨벤션을 지키면서 프로그래밍한다. 
   1. 이 과정의 Code Style은 [intellij idea Code Style. Java](https://www.jetbrains.com/help/idea/code-style-java.html)을 따른다. 
   2. intellij idea Code Style. Java을 따르려면 code formatting 단축키(Windows : Ctrl + Alt + L. Mac : ⌥ (Option) + ⌘ (Command) + L.)를 사용한다. 
3. else 예약어를 쓰지 않는다. 
   1. 힌트: if 조건절에서 값을 return하는 방식으로 구현하면 else를 사용하지 않아도 된다.
   2. else를 쓰지 말라고 하니 switch/case로 구현하는 경우가 있는데 switch/case도 허용하지 않는다.

### 기능 목록 및 commit 로그 요구사항
1. 기능을 구현하기 전에 README.md 파일에 구현할 기능 목록을 정리해 추가한다. 
2. git의 commit 단위는 앞 단계에서 README.md 파일에 정리한 기능 목록 단위로 추가한다. 
   1. 참고문서: [AngularJS Commit Message Conventions](https://gist.github.com/stephenparish/9941e89d80e2bc58a153)

## Done
1. 초간단 자동차 경주 게임을 구현한다.
2. 주어진 횟수 동안 일정 기준(4번)에 대해서 n대의 자동차는 전진 또는 멈출 수 있다.
3. 사용자는 몇 대의 자동차로 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
   * 테스트에서는 System.In으로 대체
4. 전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4이상일 경우이다.
5. 자동차의 상태를 화면에 출력한다. 어느 시점에 출력할 것인지에 대한 제약은 없다.
   * 최종 시점에 출력하는 것으로 진행함

---
### (피드백) Todo
1. README.md 수정
2. 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 구분
3. 랜덤한값을 외부로부터 전달받도록 개선 또는 행위를 교환 가능한 형태로 캡슐화하는 전략패턴 적용
4. 특정한 의미를 나타내는 매직넘버는 상수로 표현
5. 도메인 코드에선 View 에 대한 의존성이 없도록
6. View 에서 cars 를 필드로 관리해야하는 이유
7. 테스트코드도 마찬가지로 View 에 의존적이지 않은 형태를 고민
8. main 메서드가 없어서 실행결과를 확인할수 없음

### (피드백) Done
1. README.md 수정
2. 핵심로직(이동)과 현재위치 표현 로직 분리
3. 외부에서 랜덤한 값 혹은 결정된 값을 받기 위한 Interface 추가
   1. 생성자에 매개변수가 없을 경우, 기본 random값을 호출하도록 생성자 생성
   2. 생성자에 구현체를 받아서 랜덤값을 정할 수 있도록 변경
4. 특정한 의미를 나타내는 매직넘버는 상수로 표현
5. 도메인 코드에서 View에 의존적이지 않도록 변경
6. View 에서는 받은 데이터를 표기하도록 하는 로직만 구현
7. 테스트코드에서 View에 의존적이지 않도록 구현
8. main 메서드를 가진 CarRacingApplication 생성