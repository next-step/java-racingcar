package study;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class SetTest {

  private Set<Integer> numbers;

  @BeforeEach
  void setUp() {
    numbers = new HashSet<>();
    numbers.add(1);
    numbers.add(1);
    numbers.add(2);
    numbers.add(3);
  }

  @DisplayName("Set contains 테스트")
  @Test
  void setSizeTest() {
    assertThat(numbers).hasSize(3);
  }

  @DisplayName("Set contains 테스트")
  @Test
  void containsTest() {
    assertThat(numbers.contains(1)).isTrue();
    assertThat(numbers.contains(2)).isTrue();
    assertThat(numbers.contains(3)).isTrue();
  }

  @DisplayName("Set contains Parameterized 테스트 ")
  @ParameterizedTest
  @ValueSource(ints = {1, 2, 3})
  void containsParameterizeTest(int number) {
    assertThat(numbers.contains(number)).isTrue();
  }


  @DisplayName("Set contains CsvSource 테스트")
  @ParameterizedTest
  @CsvSource(value = {"1, true", "2, true", "3, true", "4, false"})
  void containsCsvSourceTest(int number, boolean expected) {
    assertThat(numbers.contains(number)).isEqualTo(expected);
  }
}
