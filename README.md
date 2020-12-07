# Step3 자동차 경주

## 기능 구현 목록

* 랜덤 수 생성 테스트 코드
* 자동차 객체 생성
* 자동차 주행 테스트
* 여러대 주행 테스트
* View Input, Output 구현

## 기능 요구사항

* 초간단 자동차 경주 게임을 구현
* 주어진 횟수 동안 n대(입력)의 자동차는 전진 or 멈춘다.
* 사용자는 몇 대의 자동차를 몇 번의 이동을 할 것인지를 입력한다.
* 전진하는 조건은 `0 ~ 9` 사이의 Random 값을 구한 후 임의의 값이 4이상일 경우
* 자동차의 상태를 화면에 출력한다. 어느 시점에 출력할 것인지에 대한 제약은 없다.

> 값을 입력 받는 API 는 Scanner 를 사용
> 랜덤 임의의 값은 자바 Java.util.Random 클래스의 nextInt(10) 메소드를 활용


## 프로그래밍 요구사항

* 모든 로직에 단위 테스트를 구현
    + 핵심 로직을 구현하는 코드와 UI를 담당하는 로직 구분
    + UI 로직을 InputView, ResultView 와 같은 클래스를 추가해 분리한다.
* 자바 코드 컨벤션을 지키면서 프로그래밍한다.
* else 예약어를 사용하지 않는다.

## 기능 목록 및 commit 로그 요구사항

* 기능을 구현하기 전에 README.md 파일에 구현할 기능 목록을 정리해 추가
* git 의 commit 단위는 앞 단계에서 README.md 파일에 정리한 기능 목록 단위로 추가

```
feat (feature)
fix (bug fix)
docs (documentation)
style (formatting, missing semi colons, …)
refactor
test (when adding missing tests)
chore (maintain)
```

### String 클래스 


* 요구사항 1
    + split 활용 및 assertj 테스트 코드 작성 학습
    + assertj (contains / containsExactly) 차이 학습
    + 테스트 코드 작성 학습
* 요구사항 2
    + subString 활용 학습
* 요구사항 3
    + charAt 확용 학습
    + 배열 예외 처리 학습
      - 예외가 발생할 경우와 발생하지 않는 경우 테스트코드 생성
    + JUnit @DisplayNAme 학습

### Set Collection

* 요구사항 1
    + Set Collection size 사용 학습
* 요구사항 2
    + contain 메소드를 활용해 Collection 의 값 확인 학습테스트
    + 중복코드 제거 -> JUnit Parameterized Test 학습 및 활용
* 요구사항 3
    + 다양한 Test Case 구현
    + CsvSource 활용한 테스트 케이스 만들기


## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)
