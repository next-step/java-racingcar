# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

# 1단계 - 학습 테스트 실습
***
## 나의 학습 목표
- 익숙한 Java API로 단위테스트를 작성하여 향후 좋은 습관을 위해 학습테스트를 실습해본다.
## String 클래스에 대한 학습 테스트
### 요구사항
- [x] `"1,2"`을 `,`로 `split` 했을 때 1과 2로 잘 분리되는지 확인하 테스트를 구현한다.
- [x] `"1"`을 `,`로 `split` 했을 때 1만을 포함하는 배열 반환되는지 대한 학습 테스트를 구현한다.
- [x] `"(1,2)"`값이 주어졌을 때 String의 `substring()` 메서드를 활용해 `()`을 제거하고 `"1,2"`를 반환하도록 구현한다.
- [x] `"abc"`값이 주어졌을 때 String의 `charAt()` 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트를 구현한다.
- [x] String의 `charAt()` 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 `StringIndexOutOfBoundsException` 발생하는 부분에 대 학습 테스트를 구현한다.
- [x] JUnit의 `@DisplayName`을 활용해 테스트 메소드의 의도를 드러낸다.
## Set Collection에 대한 학습 테스트

### 요구사항
- [x] Set의 `size()` 메소드를 활용해 Set의 크기를 확인하는 학습테스트를 구현한다.
- [x] Set의 `contains()` 메소드를 활용해 `1, 2, 3`의 값이 존재하는지를 확인하는 학습테스트를 구현하려한다.
  - JUnit의 `ParameterizedTest`를 활용해 중복 코드를 제거해 본다.
- [x] 입력 값에 따라 결과 값이 다른 경우에 대한 테스트도 가능하도 구현한다.
  - ex) `1, 2, 3`값은 `contains` 메소드 실행결과 `true`, `4,5` 값을 넣으면 `false`가 반환되는 테스트를 하나의 Test Case로 구현한다.
## 코드 리뷰 
> PR 링크:
> [https://github.com/next-step/java-racingcar/pull/6170](https://github.com/next-step/java-racingcar/pull/6170)
# 2단계 - 문자열 덧셈 계산기
***
## 나의 학습 목표
- `Red → Green → Refactor`에 따라 단계적으로 구현하며 테스트 주도 개발의 기본 흐름을 체득한다.
- 메서드를 세밀하게 분리하고 책임을 명확히 하며, 작은 단위의 리팩터링을 반복적으로 수행하는 습관을 기른다.
- 단순한 절차적 분리가 아닌, 객체가 스스로 책임을 수행하도록 설계하는 사고 전환을 연습한다.
## 기능 요구사항
- [x] 빈 문자열 또는 null 값을 입력할 경우 0을 반환한다.
- [x] 쉼표`,` 또는 콜론`:`을 구분자로 가지는 문자열을 입력할 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환한다.
- [x] 기본 구분자 외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분에 `//`와 `\n`사이에 위치한 문자를 사용한다.
- [x] 음수를 입력할 경우 RuntimeException 예외가 발생한다.
## 프로그래밍 요구사항
- 메서드가 너무 많은 일을 하지 않도록 분리하기 위해 노력해 본다.
## 코드 리뷰
> PR 링크:
> [https://github.com/next-step/java-racingcar/pull/6180](https://github.com/next-step/java-racingcar/pull/6180)
# 3단계 - 자동차 경주
***
## 나의 학습 목표
- TDD 사이클(Red-Green-Refactor)을 준수하여 기능을 구현한다.
- 책임 주도 설계 원칙에 따라 객체의 역할과 책임을 명확히 분리한다.
- 의도가 드러나는 클래스명과 메서드명을 사용한다.
- 테스트 가능한 구조로 설계하여 단위 테스트 작성을 용이하게 한다.
- UI 로직과 도메인 로직을 명확히 분리한다.
## 요구사항
- 초간단 자동차 경주 게임을 구현한다.
## 기능 요구사항
- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 사용자는 몇 대의 자동차로 몇 번의 이동을 할 것인지를 입력할 수 있다.
- 전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4이상일 경우이다.
- 자동차의 상태를 화면에 출력한다. 어느 시점에 출력할 것인지에 대한 제약은 없다.
## 프로그래밍 요구사항
- 모든 로직에 단위 테스트를 구현한다. 단, UI(`System.out`, `System.in`) 로직은 제외
  - 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 구분한다.
  - UI 로직을 `InputView`, `ResultView`와 같은 클래스를 추가해 분리한다.
- 자바 코드 컨벤션을 지키면서 프로그래밍한다.
  - Code Style은 [intellij idea Code Style.Java](https://www.jetbrains.com/help/idea/code-style-java.html)을 따른다.
- `else` 예약어를 쓰지 않는다.
- `switch/case`를 사용하지 않는다.
## 프로그래밍 제약사항
- 배열 대신 `Java Collection API`를 사용한다.
- `Java Stream API`를 사용하지 않는다.
- 단위 테스트 구현할 때 `Mockito`와 같은 `Mock`을 사용하지 않는다.
## commit 컨벤션
- git의 commit 단위는 기능 목록 단위로 추가한다.
- commit message 컨벤션: [AngularJS Commit Message Conventions](https://gist.github.com/stephenparish/9941e89d80e2bc58a153)
- ``` 
  feat (feature)
  fix (bug fix)
  docs (documentation)
  style (formatting, missing semi colons, …)
  refactor
  test (when adding missing tests)
  chore (maintain)
  ```
## 구현 기능 목록
### 도메인
- [ ] 자동차
  - [ ] 초기 위치 0으로 자동차 생성
  - [ ] 랜덤값이 4이상 9이하이면 전진
  - [ ] 랜덤값이 0이상 3이하이면 정지
  - [ ] 랜덤값이 0미만 또는 9초과면 예외발생
  - [ ] 전진 시 위치가 1 증가
  - [ ] 여러번 전진 시 위치가 누적된다.
  
- [ ] 자동차 그룹
  - [ ] 주어진 대수만큼 자동차를 생성
- [ ] 경주 게임
  - [ ] 주어진 횟수만큼 라운드를 진행
  - [ ] 각 라운드마다 모든 자동차가 이동
  - [ ] 각 라운드 종료 시 현재 위치를 반환
## 코드 리뷰
> PR 링크:
> 