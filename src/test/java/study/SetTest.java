package study;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

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
  @DisplayName("Set의 size() 메소드를 활용해 Set의 크기를 확인하는 학습테스트를 구현한다.")
  @Test
  void size() {
    assertThat(numbers.size()).isEqualTo(3);
  }

  @DisplayName("Set의 contains() 메소드를 활용해 1, 2, 3의 값이 존재하는지를 확인하는 학습테스트를 구현하려한다.")
  @Test
  void contains() {
    assertThat(numbers.contains(1)).isTrue();
    assertThat(numbers.contains(2)).isTrue();
    assertThat(numbers.contains(3)).isTrue();
  }

  @DisplayName("JUnit의 ParameterizedTest를 활용해 중복 코드를 제거해 본다.")
  @ParameterizedTest
  @ValueSource(ints = {1, 2, 3})
  void containsParameterized(Integer input) {
    assertThat(numbers.contains(input)).isTrue();
  }

  @DisplayName("1, 2, 3 값은 contains 메소드 실행결과 true, 4, 5 값을 넣으면 false 가 반환되는 테스트를 하나의 Test Case로 구현한다.")
  @ParameterizedTest
  @MethodSource("provideIntegerForContains")
  void containsParameterized(Integer input, Boolean expected) {
    assertThat(numbers.contains(input)).isEqualTo(expected);
  }

  private static Stream<Arguments> provideIntegerForContains() {
    return Stream.of(
        Arguments.of(1, true),
        Arguments.of(2, true),
        Arguments.of(3, true),
        Arguments.of(4, false),
        Arguments.of(5, false)
    );
  }
}