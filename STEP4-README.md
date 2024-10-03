# Step 4. 자동차 경주 (우승자)
## 기능요구사항
- 각 자동차에 이름을 부여할 수 있다. 자동차 이름은 5자를 초과할 수 없다.
- 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분한다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한명 이상일 수 있다.

## 테스트 목록
- 자동차의 이름을 입력하지 않았다면 예외가 발생한다.
- 자동차의 이름이 5자를 초과한다면, 예외가 발생한다.
- 자동차의 이름이 5자 이내라면 자동차 객체가 생성된다.
- 자동차의 이름 목록 중 5자를 초과하는 자동차 이름이 존재한다면 예외가 발생한다.
- 자동차의 이름 목록 중 비어있는 자동차 이름이 존재한다면 예외가 발생한다.
- 자동차의 이름 목록 모두 5자 이내의 이름을 입력했다면 Cars 객체가 만들어진다.
- 자동차의 이름 목록이 2보다 작을 경우 예외가 발생한다.
- 자동차 경주의 우승자는 최소 1명 이상이어야 한다.

### 실행결과
- 위 요구사항에 따라 3대의 자동차가 5번 움직였을 경우 프로그램을 실행한 결과는 다음과 같다.
~~~text
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
~~~

## 프로그래밍 요구사항
- indent(인덴트, 들여쓰기) depth를 2를 넘지 않도록 구현한다. 1까지만 허용한다.
  - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
- 함수(또는 메소드)의 길이가 15라인을 넘어가지 않도록 구현한다.
  - 함수(또는 메소드)가 한 가지 일만 잘 하도록 구현한다.
- 모든 로직에 단위 테스트를 구현한다. 단, UI(System.out, System.in) 로직은 제외
  - 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 구분한다. 
  - UI 로직을 InputView, ResultView와 같은 클래스를 추가해 분리한다.
- 자바 코드 컨벤션을 지키면서 프로그래밍한다.
  - 이 과정의 Code Style 은 [intellij idea Code Style. Java](https://www.jetbrains.com/help/idea/code-style-java.html) 를 따른다.
  - [intellij idea Code Style. Java](https://www.jetbrains.com/help/idea/code-style-java.html) 를 따르려면 code formatting 단축키(Windows : Ctrl + Alt + L. Mac : ⌥ (Option) + ⌘ (Command) + L.)를 사용한다.
- else 예약어를 쓰지 않는다.

## 기능 목록 및 commit 로그 요구사항
- 기능을 구현하기 전에 README.md 파일에 구현할 기능 목록을 정리해 추가한다.
- git 의 commit 단위는 앞 단계에서 README.md 파일에 정리한 기능 목록 단위로 추가한다.
  - 참고문서: [AngularJS Commit Message Conventions](https://gist.github.com/stephenparish/9941e89d80e2bc58a153)
### AngularJS Commit Message Conventions 중
- commit message 종류를 다음과 같이 구분
~~~text
feat (feature)
fix (bug fix)
docs (documentation)
style (formatting, missing semi colons, …)
refactor
test (when adding missing tests)
chore (maintain)
~~~