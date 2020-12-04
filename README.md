# 자동차 경주 게임

## 진행 방법

* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정

* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

---

## 1단계 - 학습 테스트 실습: String 클래스에 대한 학습 테스트

### 요구사항 1

- [X] "1,2"을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다.
- [X] "1"을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다.

### 요구사항 2

- [X] "(1,2)" 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 "1,2"를 반환하도록 구현한다.

### 요구사항 3

- [X] "abc" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트를 구현한다.
- [X] String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습 테스트를 구현한다.
- [X] JUnit의 @DisplayName을 활용해 테스트 메소드의 의도를 드러낸다.

## 1단계 - 학습 테스트 실습: Set Collection에 대한 학습 테스트

### 요구사항 1

- [X] Set의 size() 메소드를 활용해 Set의 크기를 확인하는 학습테스트를 구현한다.

### 요구사항 2

- [X] Set의 contains() 메소드를 활용해 1, 2, 3의 값이 존재하는지를 확인하는 학습테스트를 구현하려한다.
- [X] JUnit의 ParameterizedTest를 활용해 중복 코드를 제거해 본다.

### 요구사항 3

- [X] 입력 값에 따라 결과 값이 다른 경우에 대한 테스트도 가능하도록 구현한다. 예를 들어 1, 2, 3 값은 contains 메소드 실행결과 true, 4, 5 값을 넣으면 false 가 반환되는 테스트를
  하나의 Test Case로 구현한다.

---

## 2단계 - 문자열 계산기

### 목표
- 이번 미션의 핵심은 내가 구현하는 코드에 단위 테스트를 추가하는 경험을 하는 것이다.
- 모든 예외 상황을 처리하기 위해 너무 복잡하게 접근하지 않아도 된다.

### 기능 요구사항

- 인풋: 숫자 두 개와 연산자 한개.
- 아웃풋: 연산자로 두 숫자를 계산한 결과

- [ ] 사용자가 입력한 문자열 값에 따라 사칙연산을 수행
- [ ] 공백 문자로 각각의 숫자와 연산자를 분리한다.
  - [ ] 유효성 검사
- 숫자
  - [ ] 유효성 검사
- 연산자
  - 연산자는 사칙연산만
    - [X] 더하기
    - [ ] 빼기
    - [ ] 곱하기
    - [ ] 나누기
      - [ ] 0으로 나누면 throw exception
    - [ ] 아닌경우 throw exception
  - [ ] 위 연산을 모두 포함하는 기능
- 유틸
  - [ ] null or empty
  - [ ] string to long
  
### 프로그래밍 요구사항

- 메소드가 너무 많은 일을 하지 않도록 분리하기 위해 노력해 본다.
