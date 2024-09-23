# Step 1. 학습 테스트 실습
## String 클래스에 대한 학습 테스트
***
### 요구사항 1
- "1,2"를 <code>,</code>로 split 했을 때, 1과 2로 잘 분리되는 확인하는 학습 테스트를 구현한다.
- "1"을 <code>,</code>로 split 했을 때, 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다.
### 요구사항 2
- "(1,2)"값이 주어졌을 때, String 의 substring() 메소드를 활용해 <code>()</code>를 제거하고 "1,2"를 반환하도록 구현한다.
### 요구사항 3
- "abc"값이 주어졌을 때, String 의 charAt() 메소드를 활용 해 특정 위치의 문자를 가져오는 학습 테스트를 구현한다.
- String 의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때, 위치 값을 벗어나면 StringIndexOfBoundsException 이 발생하는 부분에 대해 학습 테스트를 구현한다.
- JUnit 의 @DisplayName 을 활용해 테스트 메소드의 의도를 드러낸다.

## Set Collection 에 대한 학습 테스트
***
- 다음과 같은 Set 데이터가 주어졌을 때, 요구사항을 만족해야 한다.
~~~java
public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }
    
    // Test Case 구현
}
~~~
### 요구사항 1
- Set 의 size() 메소드를 활용해 Set 의 크기를 확인하는 학습테스트를 구현한다.
### 요구사항 2
- Set 의 contains() 메소드를 활용해 1,2,3의 값이 존재하는지를 확인하는 학습테스트를 구현하려한다.
- 구현하고 보니 다음과 같이 중복 코드가 계속해서 발생한다.
- JUnit 의 ParameterizedTest 를 활용하여 중복 코드를 제거해 본다.
~~~java
    @Test
    void contains() {
        assertThat(numbers.contains(1)).isTrue();
        assertThat(numbers.contains(2)).isTrue();
        assertThat(numbers.contains(3)).isTrue();
    }
~~~
### 요구사항 3
- 요구사항 2는 contains 메소드 결과 값이 true 인 경우만 테스트가 가능하다. 입력 값에 따라 결과 값이 다른 경우에 대한 테스트도 가능하도록 구현한다.
- 예를 들어 1,2,3 값은 contains 메소드 실행 결과 true,4,5 값을 넣으면 false 가 반환되는 테스트를 하나의 Test Case 로 구현한다.