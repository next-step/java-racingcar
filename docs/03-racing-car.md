# 3단계 - 자동차 경주
***
## 코드 리뷰
> PR 링크:
> [https://github.com/next-step/java-racingcar/pull/6191](https://github.com/next-step/java-racingcar/pull/6191)
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
- [x] 자동차
    - [x] 초기 위치 0으로 자동차 생성
    - [x] 랜덤값이 4이상 9이하이면 전진
    - [x] 랜덤값이 0이상 3이하이면 정지
    - [x] 랜덤값이 0미만 또는 9초과면 예외발생
    - [x] 전진 시 위치가 1 증가
    - [x] 여러번 전진 시 위치 누적
    - [x] 현재 위치 조회
- [x] 자동차 그룹
    - [x] 입력한 자동차 대수만큼 자동차 생성
    - [x] 입력한 자동차 대수가 1 미만이면 예외발생
    - [x] 모든 자동차를 한 번에 이동
    - [x] 각 자동차는 매번 새로운 랜덤값으로 이동
    - [x] 자동차 그룹 크기 조회
    - [x] 모든 자동차의 위치 조회
- [x] 경주 게임
    - [x] 라운드 수만큼 라운드를 진행
    - [x] 라운드 수가 1미만이면 예외발생
    - [x] 각 라운드 결과 기록
    - [x] 경주 완료 후 전체 기록을 반환
- [x] 라운드 결과
    - [x] 라운드별 자동차 위치 정보 저장
    - [x] 위치 정보가 null이면 예외발생
    - [x] 위치 정보가 비어있으면 예외발생
    - [x] 라운드별 자동차 위치 정보 조회
- [x] 경주 기록
    - [x] 라운드 결과를 순차적으로 기록
    - [x] 전체 라운드 수 조회
    - [x] 특정 라운드 결과 조회
    - [x] 전체 라운드 결과 조회
- [x] 랜덤 숫자 생성
    - [x] 0~9 범위의 랜덤값 생성
