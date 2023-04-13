# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)



## 1주차 자동차 경주 기능 목록 작성
- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 사용자는 몇 대의 자동차로 몇 번의 이동을 할것인지를 입력할 수 있어야 한다.
  - 예외처리 -> 테스트 미완성
    >  - [x] 숫자가 아닌 경우 예외처리
    >  - [x] 음수일 경우 예외처리
    >  - [x] 0이거나 자연수가 아닐 경우 예외처리
- 전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4 이상일 경우이다. 
- 자동차 상태를 화면에 출력한다. 어느 시점에 출력할 것인지에 대한 제약은 없다.
  - [x] `-`를 통해서 자동차의 상태를 출력한다.
- 예시는 아래와 같다.
```
자동차 대수는 몇 대 인가요?
3
시도할 회수는 몇 회 인가요?
5

실행 결과
-
-
-

--
-
--

---
--
---

----
---
----

----
----
-----
```
## InputView에서의 기능목록
- [x] 자동차 몇 대인지 입력받기
- [x] 시도할 횟수 입력받기

## OutputView에서의 기능목록
- [x] `자동차 대수는 몇 대 인가요?` 문구 출력
- [x] `시도할 회수는 몇 회 인가요?` 문구 출력
- [x] `실행결과` 문구 출력

## 기능 목록
- [x] 자동차 대수 만큼 Car 객체를 생성한다. - 테스트 완료 (GameCarsTest)
- [x] Random을 통해서 4 이상일 경우 Car 객체의 moveCount를 증가 시킨다. - 테스트 완료 (CarTest)
- [x] 시도할 회수 만큼 각 Car에 대해서 위 Random 함수를 호출해 결과를 출력한다. 

## 프로그래밍 요구사항
- [x] 모든 로직에 단위테스트 구현한다.
    - [x] 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 구분한다.
    - [x] UI 로직을 InputView, ResultView와 같은 클래스를 추가해 분리한다.
- [x] 자바 코드 컨벤션을 지킨다.
- [x] else 예약어를 쓰지 않는다.
- [x] 기능 목록 작성하기
- [x] 기능 목록 단위로 commit 하며 commit message를 angularJS commit message convention을 따른다.