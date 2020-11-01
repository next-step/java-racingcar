# 자동차 경주 게임

## 1단계 - 학습 테스트 실습

---

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

---

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

