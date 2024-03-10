# 자동차 경주 게임

## 진행 방법

* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정

* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

---

# 1단계 - 학습 테스트 실습

<details>
  <summary>요구사항 보기</summary>

## String 클래스에 대한 학습 테스트

### 요구사항 1

- [x] "1,2"을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다.
- [x] "1"을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다.

### 요구사항 2

- [x] "(1,2)" 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 "1,2"를 반환하도록 구현한다.

### 요구사항 3

- [x] "abc" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트를 구현한다.
- [x] String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습 테스트를 구현한다.
- [x] JUnit의 @DisplayName을 활용해 테스트 메소드의 의도를 드러낸다.

## Set Collection에 대한 학습 테스트

### 요구사항 1

- [x] Set의 size() 메소드를 활용해 Set의 크기를 확인하는 학습테스트를 구현한다.

### 요구사항 2

- [x] Set의 contains() 메소드를 활용해 1, 2, 3의 값이 존재하는지를 확인하는 학습테스트를 구현하려한다.
- [x] 구현하고 보니 다음과 같이 중복 코드가 계속해서 발생한다.
- [x] JUnit의 ParameterizedTest를 활용해 중복 코드를 제거해 본다.

### 요구사항 3

- [x] 요구사항 2는 contains 메소드 결과 값이 true인 경우만 테스트 가능하다. 입력 값에 따라 결과 값이 다른 경우에 대한 테스트도 가능하도록 구현한다.
- [x] 예를 들어 1, 2, 3 값은 contains 메소드 실행결과 true, 4, 5 값을 넣으면 false 가 반환되는 테스트를 하나의 Test Case로 구현한다.

</details>

---

# 2단계 - 문자열 덧셈 계산기를 통한 TDD 실습

<details>
  <summary>요구사항 보기</summary>

### 기능 요구사항

- 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환
    - (예: “” => 0, "1,2" => 3, "1,2,3" => 6, “1,2:3” => 6)
- 앞의 기본 구분자(쉼표, 콜론)외에 커스텀 구분자를 지정할 수 있다.
    - 커스텀 구분자는 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다.
    - 예를 들어 “//;\n1;2;3”과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
- 문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw한다.

### 프로그래밍 요구사항

- 메소드가 너무 많은 일을 하지 않도록 분리하기 위해 노력해 본다.

### 요구사항 분리

- [x] 입력값이 null 또는 trim 후 빈 문자열이라면 0을 반환한다
- 구분자 없이
    - [x] 0 또는 양의 숫자 하나를 전달했다면 해당 숫자를 반환한다
    - [x] 숫자 이외의 값 하나 또는 음수 하나를 전달했다면 RuntimeException이 발생한다
- 쉼표와 콜론 혼합 구분자로 여러 개의 수들을 전달했을 때
    - [x] 양의 숫자로만 이루어졌다면 해당 값들을 합산한 결과를 반환한다
    - [x] 숫자 이외의 값 또는 음수가 하나라도 포함된다면 RuntimeException이 발생한다
- 커스텀 구분자로 여러 개의 수들을 전달했을 때
    - [x] 양의 숫자로만 이루어졌다면 해당 값들을 합산한 결과를 반환한다
    - [x] 숫자 이외의 값 또는 음수가 하나라도 포함된다면 RuntimeException이 발생한다

### 리팩터링

```java
// as-is
public static int splitAndSum(String input) {
    if (isNullOrEmpty(input)) {
        return DEFAULT_VALUE_FOR_EMPTY_INPUT;
    }

    if (doesNotContainAnyDelimiter(input)) {
        return parsePositiveSingleNumber(input);
    }

    if (defaultDelimiterIsUsed(input)) {
        return sumAfterSplitByDelimiter(input, COMMA_OR_COLON_DELIMITER);
    }

    return sumAfterSplitByCustomDelimiter(input);
}
```

- 하나의 메서드인데 분기마다 다른 메서드를 호출한 결과를 반환 -> 가독성이 떨어진다
- null 또는 빈 문자열 체크 -> 구분자 획득 -> split -> sum
    - public으로 열린 splitAndSum 메서드에서는 위 동작 흐름만 나타날 수 있게 리팩터링 해보자

- [x] split
    - [x] 커스텀 구분자 정규식에
        - [x] 일치하면 커스텀 구분자로 split한 문자열 배열을 반환
        - [x] 일치하지 않으면 기본 구분자로 split한 문자열 배열을 반환
- [x] parseInt and sum
    - [x] 문자열 배열을 전달받아 Stream API로 아래 메서드를 활용하여 mapToInt한 결과를 sum하여 반환
        - [x] `StringAddCalculator#parsePositiveSingleNumber`: 파싱한 결과가 음수이면 예외 반환, 0 또는 양수이면 숫자 반환
        - [x] `StringAddCalculator#parseSingleNumber`: 파싱한 결과가 숫자면 반환, 아닐 경우 RuntimeException 던지기

```java
// to-be
public static int splitAndSum(final String input) {
    if (isNullOrEmpty(input)) {
        return DEFAULT_VALUE_FOR_EMPTY_INPUT;
    }

    final String[] splitInput = splitByDelimiter(input);

    return parseIntAndSum(splitInput);
}
```

</details>

---

# 3단계 - 자동차 경주

## 기능 요구사항

- 초간단 자동차 경주 게임을 구현한다.
- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 사용자는 몇 대의 자동차로 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4이상일 경우이다.
- 자동차의 상태를 화면에 출력한다. 어느 시점에 출력할 것인지에 대한 제약은 없다.

## 힌트

- 값을 입력 받는 API는 Scanner를 이용한다.
- 랜덤 값은 자바 java.util.Random 클래스의 nextInt(10) 메소드를 활용한다.

## 요구사항 분리

- [x] `자동차 대수는 몇 대 인가요?` -> 양의 정수 하나를 입력 받음
- [x] `시도할 회수는 몇 회 인가요?` -> 양의 정수 하나를 입력 받음
- [ ] 개행 및 `실행 결과` 출력
- [x] 0-9사이 Random 값이 4이상인 경우 전진하는 메서드 구현
- [ ] 입력 받은 시도 횟수 만큼 개행으로 구분하며 각 자동차의 경과를 출력
