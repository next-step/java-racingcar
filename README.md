## 1단계 - 학습 테스트 실습

### String 클래스에 대한 학습 테스트

#### 요구사항 1

- "1,2"을 `,`로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현
- "1"을 `,`로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다.

#### 요구사항 2

- "(1,2)" 값이 주어졌을 때 String의 substring() 메서드를 활용해 `()` 을 제거하고 "1,2"를 반환하도록 구현한다.

#### 요구사항 3

- "abc"값이 주어졌을 때 String의 charAt() 메서드를 활용해 특정 위치의 문자를 가져오는 학습 테스트를 구현한다.
- String의 charAt() 메서드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 `StringINdexOutOfBoundsException` 이 발생하는 부분에 대한 학습 테스트를 구현한다.
- Junit의 @DisplayName을 활용해 테스트 메서드의 의도를 드러낸다.


### Set Collection에 대한 학습 테스트

#### 요구사항 1
- Set의 size() 메서드를 활용해 Set의 크기를 확인하는 학습테스트를 구현한다.

#### 요구사항 2

[JUnit5 공문](https://www.baeldung.com/parameterized-tests-junit-5)

- Set의 contains() 메서드를 활용해 1, 2, 3의 값이 존재하는지를 확인하는 학습테스트를 구현하려고 한다.
- 구현하고 보니 다음과 같이 중복 코드가 계속해서 발생한다.
- Junit의 ParameterizedTest를 활용해 중복 코드를 제거 하자.

```java
@Test
void contains() {
  assertThat(numbers.contains(1)).isTrue();
  assertThat(numbers.contains(2)).isTrue();
  assertThat(numbers.contains(3)).isTrue();
}
```

#### 요구사항 3
[JUnit5 공문](https://www.baeldung.com/parameterized-tests-junit-5)
- 요구사항 2는 contains 메서드 결과 값이 true인 경우만 테스트가 가능하다.
  입력 값에 따라 결과 값이 다른 경우에 대한 테스트도 가능하도록 구현한다.
- 예를 들어 1, 2, 3 값은 contains 메서드 실행결과 true
  4, 5 값은 false가 반환되는 테스트를 하나의 Test Case로 구현하라.

## 2단계 - 문자열 사칙연산 계산기 구현
- 단위테스트 경험하기가 핵심
  즉, 너무 복잡하기 접근하지 마라.

### 기능 요구사항
- 사용자가 입력한 문자열 값에 따라 사칙연산을 수행할 수 있는 계산기를 구현해야 한다.
- 입력 문자열의 숫자와 사칙 연산 사이에는 **`반드시 빈 공백 문자열`**  이 있다고 가정
- `누눗셈의 경우 결과 값을 정수` 로 떨어지는 값으로 한정
- 문자열 계산기는 `사칙연산의 계산 우선순위가 아닌 입력 값에 따라 계산 순서가 결정` 
  즉, 수학에서는 곱셉, 나눗셈이 덧셈, 뺄셈 보다 먼저 계산해야 하지만 이를 무시
- 예로** `2 + 3 * 4 / 2`** 와 같은 문자열을 입력할 경우 `10을 출력해야 한다.

### 프로그래밍 요구사항
- 메서드가 너무 많은 일을 하지 않도록 분리하기 위해 노력해 본다.

### 기능 분리 힌트
- 테스트 할 수 있는 단위로 나누어 구현 목록을 만든다.
  - 덧셈
  - 뺄셈
  - 곱셈
  - 나눗셈
  - 입력 값이 **`null 이거나 빈 공백`** 문자열일 경우** `IllegalArgumnetException throw`**
  - 사칙연산 기호가 아닌 경우** `IllegalArgumnetException throw`**
  - 사칙 연산을 모두 포함하는 기능 구현
- 공백 문자열을 빈 공백 문자로 분리하려면 String 클래스의 **`split(" ")`** 메서드를 활용한다.
- 반복적인 패턴을 찾아 반복문을 구현한다.

## 자동차경주

### 기능요구 사항

- 초간단 자동차 경주게임
- 주어진 횟수동안 n대의 자동차는 전진 또는 정지할 수 있다.
- 사용자는 몇 대의 자동차로 몇 번 이동할지 입력할 수 있다.
- 전진 조건은 0 ~ 9 까지 random 값 중 4이상 일 때 이다.
- 자동차의 상태를 출력한다. 어느 시점에 출력할지에 대한 제약은 없다.

### 실행결과

```
자동차 대수는 몇대 인가요?
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

### 힌트
- 값을 입력 받는 API는 Scanner를 이용한다.
```java
Scanner scanner = new Scanner(System.in);
String value = scanner.nextLine();
int number = scanner.nextInt();
```
- 랜덤 값은 자바 java.util.Random 클래스의 nextInt(10) 메소드를 활용한다.

### 프로그래밍 요구사항

- 모든 로직에 테스트를 구현한다. 단, UI(System.out, System.in) 로직은 제외
  - 핵심 로직을 구현하는 코드와 UI 담당 로직을 분리한다.
  - UI 로직을 InputView, ResultView와 같은 클래스로 분리한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)