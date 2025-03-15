## 자동차 경주 게임

- [ ] 주어진 횟수 동안 n대의 자동차는 전진 할 수 있다.
- [ ] 주어진 횟수 동안 n대의 자동차는 멈출 수 있다.
- [ ] 사용자는 1회의 시도에 몇 대의 자동차를 사용할지 입력할 수 있다.
  - 값을 입력 받는 API는 `Scanner`를 이용한다.
- [ ] 사용자는 1회의 시도에 몇 번의 이동을 할 것인지 입력할 수 있다.
- [ ] 0-9 사이의 랜덤값을 구해 4 이상일 경우 전진한다.
  - 랜덤 값은 자바 `java.util.Random` 클래스의 `nextInt(10)` 메소드를 사용한다.
- 자동차의 상태를 화면에 출력한다.

---

## 프로그래밍 요구사항
- 모든 로직에 단위 테스트를 구현한다. 단, UI(System.out, System.in) 로직은 제외 
  - 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 구분한다. 
  - UI 로직을 InputView, ResultView와 같은 클래스를 추가해 분리한다.
- 자바 코드 컨벤션을 지키면서 프로그래밍한다.
  - 이 과정의 Code Style은 [intellij idea Code Style. Java](https://www.jetbrains.com/help/idea/code-style-java.html)을 따른다. 
  - [intellij idea Code Style. Java](https://www.jetbrains.com/help/idea/code-style-java.html)을 따르려면 code formatting 단축키(Windows : Ctrl + Alt + L. Mac : ⌥ (Option) + ⌘ (Command) + L.)를 사용한다. 
- else 예약어를 쓰지 않는다. 
  - 힌트: if 조건절에서 값을 return하는 방식으로 구현하면 else를 사용하지 않아도 된다. 
  - else를 쓰지 말라고 하니 switch/case로 구현하는 경우가 있는데 switch/case도 허용하지 않는다.

---

## 커밋 로그 요구사항

- git의 commit 단위는 앞 단계에서 README.md 파일에 정리한 기능 목록 단위로 추가한다.
- 참고문서: [AngularJS Commit Message Conventions](https://gist.github.com/stephenparish/9941e89d80e2bc58a153) 

### AngularJS Commit Message Conventions 에서는 ...
commit message 종류를 다음과 같이 구분한다.

``` 
fix (bug fix)
docs (documentation)
style (formatting, missing semi colons, …)
refactor
test (when adding missing tests)
chore (maintain)
```