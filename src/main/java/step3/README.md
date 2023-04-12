# 3단계 - 자동차 경주

## 기능 요구사항

- 초간단 자동차 경주 게임을 구현한다.
- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 사용자는 몇 대의 자동차로 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4이상일 경우이다.
- 자동차의 상태를 화면에 출력한다. 어느 시점에 출력할 것인지에 대한 제약은 없다.

## 프로그래밍 요구사항

- 모든 로직에 단위 테스트를 구현한다. 단, UI(System.out, System.in) 로직은 제외
- 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 구분한다.
- UI 로직을 InputView, ResultView와 같은 클래스를 추가해 분리한다.
- 자바 코드 컨벤션을 지키면서 프로그래밍한다. 이 과정의 Code Style은 intellij idea Code Style. Java을 따른다.
    - intellij idea Code Style. Java을 따르려면 code formatting 단축키(Windows : Ctrl + Alt + L. Mac : ⌥ (Option) + ⌘ (
      Command) + L.)를 사용한다.

- else 예약어를 쓰지 않는다.
- 힌트: if 조건절에서 값을 return하는 방식으로 구현하면 else를 사용하지 않아도 된다.
  else를 쓰지 말라고 하니 switch/case로 구현하는 경우가 있는데 switch/case도 허용하지 않는다.

## 기능 목록 및 commit 로그 요구사항

- 기능을 구현하기 전에 README.md 파일에 구현할 기능 목록을 정리해 추가한다.
- git의 commit 단위는 앞 단계에서 README.md 파일에 정리한 기능 목록 단위로 추가한다.
- 참고문서: AngularJS Commit Message Conventions

```
AngularJS Commit Message Conventions 중
commit message 종류를 다음과 같이 구분
feat (feature)
fix (bug fix)
docs (documentation)
style (formatting, missing semi colons, …)
refactor
test (when adding missing tests)
chore (maintain)
```

## 구현 기능 목록

- [x] 각 자동차에 이름을 부여할 수 있다. 자동차 이름은 5자를 초과할 수 없다.
- [x] 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- [x] 자동차 이름은 쉼표(,)를 기준으로 구분한다.
- [x] 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한명 이상일 수 있다.

## 구현 설명

### util

`NumberValidator`

- 입력받은 숫자가 각각 자동차의 수와 이동 횟수에 적합한 숫자인지 확인하는 유틸성 클래스

`RandomNumberGenerator`

- 0 ~ 9 사이의 랜덤한 숫자를 생성하는 유틸성 클래스

`RacingCreateHelper`

- 여러개의 객체 생성을 도와주는 유틸성 클래스

### domain

`Racecource`
- 자동차 경주를 진행하는 레이스코스를 나타내는 클래스
- 자동차를 입장시키면 비어있는 트랙에 자동차를 입장시킨다
- 이동신호를 주면 모든 트랙에 있는 자동차에게 이동신호를 준다

`Track`
- 자동차 경주를 진행하는 트랙을 나타내는 클래스
- 트랙 내부 자동차의 위치를 나타내는 `CarPosition`을 가진다
- 전진신호를 자동차에게 전달할 수 있다

`RacingCar`
- 자동차 경주를 진행하는 자동차를 나타내는 클래스
- 전진 시도시 랜덤한 숫자를 생성하여 전진 여부를 판단한다
- 전진 판단시 1만큼 전진한다
- 전진여부를 판단하는 기준은 `RandomNumberGenerator`를 통해 생성된 랜덤한 숫자가 4이상인 경우이다
- 기본 전진 전략으로 `RandomMove` 전략을 사용하며, 확장성을 위해 `MoveStrategy` 인터페이스를 구현한다
