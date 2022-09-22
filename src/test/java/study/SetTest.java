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
import org.junit.jupiter.params.provider.CsvSource;
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
  @DisplayName("Check size of Set")
  @Test
  void setSize() {
    assertThat(numbers.size()).isInstanceOf(Integer.class);
    System.out.println("numbers.size = " + numbers.size());
  }

  @DisplayName("Check set elements")
  @ValueSource(ints = {1, 2, 3})
  @ParameterizedTest
  void setElementCheck(int i) {
    assertThat(numbers.contains(i)).isTrue();
  }

  @DisplayName("Check set elements")
  @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
  @ParameterizedTest
  void setElementCheck2(int input, boolean expected) {
    assertThat(numbers.contains(input)).isEqualTo(expected);
  }

  @DisplayName("Check set elements")
  @MethodSource("provideStringsForIsBlank")
  @ParameterizedTest
  void setElementCheck3(int input, boolean expected) {
    assertThat(numbers.contains(input)).isEqualTo(expected);
  }

  private static Stream<Arguments> provideStringsForIsBlank() {
    return Stream.of(
        Arguments.of(1, true),
        Arguments.of(2, true),
        Arguments.of(3, true),
        Arguments.of(4, false),
        Arguments.of(5, false)
    );
  }
}
