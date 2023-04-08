# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)


## MISSION
1. Parameterized Test
  - 하나의 테스트 메소드로 여러 개의 파라미터에 대해 테스트할 수 있다.
  - 최소 하나의 source 어노테이션을 붙여주어야 한다. 
    - @ValueSource
    - @NullAndEmptySource
    - @NullSource
    - @EmptySource
    - @EnumSource
    - @MethodSource


## CODE REVIEW (문선흠님)

  - 
    ```
    In src/test/java/study/SetTest.java:
    
    > +        numbers.add(1);
    +        numbers.add(1);
    +        numbers.add(2);
    +        numbers.add(3);
    +    }
    +
    +    // Test Case 구현
    +    @Test
    +    @DisplayName("test Set size()")
    +    void setSize(){
    +        assertThat(numbers.size()).isEqualTo(3);
    +    }
    +
    +    @ParameterizedTest
    +    @ValueSource(ints = {1,2,3})
    +    @DisplayName("test Set contains() with ValueSource")
    ***@ParameterizedTest에는 name 프로퍼티가 있어서 @DisplayName으로 안주셔도 돼요!
    ```
    ```
    In src/test/java/study/SetTest.java:
    > +    // Test Case 구현
    + @Test
    + @DisplayName("test Set size()")
    + void setSize(){
    +        assertThat(numbers.size()).isEqualTo(3);
    + }
    + 
    + @ParameterizedTest
    + @ValueSource(ints = {1,2,3})
    + @DisplayName("test Set contains() with ValueSource")
    + void setContainsWithValueSource(int number){
    +        assertThat(numbers.contains(number)).isTrue();
    + }
    + 
    + @ParameterizedTest
    + @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    ***개인적으로는 @MethodSource를 주로 쓰는 편인데, 한번 확인해 보시면 좋을 것 같아요 :)
    ```
    ```
    In src/test/java/study/StringTest.java:
    > +
    +import static org.assertj.core.api.Assertions.assertThat;
    +import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
    +@Nested
    +@DisplayName("first next step test")
    +public class StringTest {
    +    @Test
    +    @DisplayName("test split")
    +    void split() {
    +        String[] result = "1,2".split(",");
    +        assertThat(result).contains("1");
    +        assertThat(result).containsExactly("1","2");
    +
    +        String[] result2 = "1".split(",");
    +        for (String s : result2) {
    ***result2나 s 처럼 의미가 불분명한 변수명은 지양하는게 좋을 것 같아요 :)
    추가로, 현재 given, when, then 이 어떻게 나뉘어 있는 걸까요 ?
    테스트가 분리 되어야 하는 상황은 아닐까요 ?
    ```
    ```
    In src/test/java/study/StringTest.java:

    > +            assertThat(s).contains("1");
    +        }
    +    }
    +
    +    @Test
    +    @DisplayName("test substring")
    +    void substring() {
    +        String result = "(1,2)".substring(1, 4);
    +        assertThat(result).isEqualTo("1,2");
    +    }
    +
    +    @Test
    +    @DisplayName("test charAt")
    +    void charAt() {
    +        String request = "abc";
    +        int index = 10;
    ****보통 이런 범위를 테스트하는 경우에는,한계값으로 테스트를 해요! 
    지금 케이스론 설명이 조금 부족할 수 있지만, 기준이 바뀌면 테스트도 깨져야 하는데, 
    너무 넓은 범위를 잡으면 비즈니스가 바뀐 걸 인지하지 못 할 수가 있어요 :)
    ```


## JUnit @ParameterizedTest
## JUnit @MethodSource