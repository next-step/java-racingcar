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
   * 최종 시점에 출력하는 것으로 변경함

---

# Step 2
## ToDo
1. README.md 정리해보기
2. 프로덕션 코드 패키지 위치 변경
3. void 콜론_콤마_구분자() 테스트 재확인
4. isMinus Method 예외 확인 ( parameter : "1,2" )
5. 구분자 문자를 확인하는 로직 추가

## Done
1. 정리 완료
2. 위치 변경 완료
3. void 콜론_콤마_구분자() 테스트 재확인
4. isMinus Method 호출 전 parameter 입력 로직 변경
5. 구분자 문자 및 문자열 계산을 위한 Text를 확인하는 메소드 추가 및 테스트 확인